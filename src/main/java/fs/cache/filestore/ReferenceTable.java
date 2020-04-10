package fs.cache.filestore;

import fs.cache.filestore.util.CRC32HGenerator;
import fs.io.BufferReader;


public final class ReferenceTable {

    public final int crc;
    public final int revision;

    public final int archiveCount;
    public final int[] archiveIds;
    public final Archive[] archives;

    public ReferenceTable(byte[] archiveData) {
        this.crc = CRC32HGenerator.getHash(archiveData);

        BufferReader reader = new BufferReader(Archive.decompress(archiveData, null));

        int protocol = reader.getUnsignedByte();
        if (protocol < 5 || protocol > 7) {
            throw new RuntimeException("Invalid Protocol!");
        }

        revision = protocol >= 6 ? reader.getUnsignedInt() : 0;

        int hash = reader.getUnsignedByte();
        boolean named = (0x1 & hash) != 0;
        boolean hash4 = (hash & 0x4) != 0;
        boolean hash8 = (hash & 0x8) != 0;

        this.archiveCount = protocol >= 7 ? reader.readBigSmart() : reader.getUnsignedShort();
        this.archiveIds = new int[archiveCount];

        int lastArchiveId = 0;
        int highestArchiveId = -1;
        for (int index = 0; index < archiveCount; index++) {
            int archiveId = lastArchiveId += protocol >= 7 ? reader.readBigSmart() : reader.getUnsignedShort();
            if (archiveId > highestArchiveId) {
                highestArchiveId = archiveId;
            }
            archiveIds[index] = archiveId;
        }

        archives = new Archive[highestArchiveId + 1];
        for (int index = 0; index < archiveCount; index++) {
            int archiveId = archiveIds[index];
            archives[archiveId] = new Archive();
        }

        if (named) {
            for (int index = 0; index < archiveCount; index++) {
                int archiveId = archiveIds[index];
                archives[archiveId].nameHash = reader.getUnsignedInt();
            }
        }

        for (int index = 0; index < archiveCount; index++) {
            int archiveId = archiveIds[index];
            archives[archiveId].crc = reader.getUnsignedInt();
        }

        if (hash8) {
            for (int index = 0; index < archiveCount; index++) {
                int archiveId = archiveIds[index];
                archives[archiveId].someHashValue8 = reader.getUnsignedInt();
            }
        }

        if (hash4) {
            for (int index = 0; index < archiveCount; index++) {
                int archiveId = archiveIds[index];
                archives[archiveId].someHashValue4_1 = reader.getUnsignedInt();
                archives[archiveId].someHashValue4_2 = reader.getUnsignedInt();
            }
        }

        for (int index = 0; index < archiveCount; index++) {
            int archiveId = archiveIds[index];
            archives[archiveId].revision = reader.getUnsignedInt();
        }

        for (int index = 0; index < archiveCount; index++) {
            int archiveId = archiveIds[index];
            int fileCount = protocol >= 7 ? reader.readBigSmart() : reader.getUnsignedShort();
            archives[archiveId].fileCount = fileCount;
            archives[archiveId].fileIds = new int[fileCount];
        }

        for (int index = 0; index < archiveCount; index++) {
            int archiveId = archiveIds[index];
            Archive archive = archives[archiveId];

            int lastFileId = 0;
            int highestFileId = -1;
            for (int i = 0; i < archive.fileCount; i++) {
                int fileId = lastFileId += protocol >= 7 ? reader.readBigSmart() : reader.getUnsignedShort();
                if (fileId > highestFileId) {
                    highestFileId = fileId;
                }
                archive.fileIds[i] = fileId;
            }

            archive.files = new Archive.File[highestFileId + 1];
            for (int i = 0; i < archive.fileCount; i++) {
                int fileId = archive.fileIds[i];
                archive.files[fileId] = new Archive.File();
            }
        }

        if (named) {
            for (int index = 0; index < archiveCount; index++) {
                int archiveId = archiveIds[index];
                Archive archive = archives[archiveId];
                boolean b = archive.files.length == archive.fileCount;
                for (int i = 0; i < archive.fileCount; i++) {
                    int fileId;
                    if (!b) {
                        fileId = archive.fileIds[i];
                    } else {
                        fileId = i;
                    }
                    archive.files[fileId].nameHash = reader.getUnsignedInt();
                }
            }
        }
    }

}
