package fs.cache.filestore.util;

import fs.io.BufferReader;

import java.util.zip.Inflater;

/**
 * Deobfuscated class from a build 189 OSRS client.
 */
public final class Class60 {

    private Inflater inflater;

    public void decompress(BufferReader reader, byte[] bytes) {
        if (reader.getBytes()[reader.position()] != 31 || reader.getBytes()[reader.position() + 1] != -117) {
            throw new RuntimeException("Invalid GZIP header!");
        }

        if (inflater == null) {
            inflater = new Inflater(true);
        }

        try {
            inflater.setInput(reader.getBytes(), reader.position() + 10, (reader.getBytes().length - (reader.position() + 8 + 10)));
            inflater.inflate(bytes);
        } catch (Exception exception) {
            inflater.reset();
            throw new RuntimeException("Invalid GZIP compressed data!");
        }

        inflater.reset();
    }

}