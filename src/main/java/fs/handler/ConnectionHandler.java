package fs.handler;

import fs.cache.CacheManager;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetSocket;
import fs.FileServerConfig;
import fs.io.BufferReader;
import fs.io.BufferWriter;

/**
 * An implementation of Handler that is executed for every connection.
 *
 * @author Andys1814
 */
public final class ConnectionHandler implements Handler<Buffer> {

    private static final CacheManager cacheManager = new CacheManager(FileServerConfig.FILESTORE);

    private final NetSocket socket;

    public ConnectionHandler(NetSocket socket) {
        this.socket = socket;
    }

    @Override
    public void handle(Buffer buffer) {
        BufferReader reader = new BufferReader(buffer.getBytes());

        int type = reader.getUnsignedByte();
        int index = reader.getUnsignedByte();
        int archive = reader.getUnsignedShort();

        switch (type) {
            case 0: // Normal request
            case 1: // Priority request
                System.out.println("yeah");
                BufferWriter writer = cacheManager.get(index, archive, type == 1);
                if (writer != null) {
                    socket.write(writer.getBuffer());
                }
                break;

            case 4:
                // Encryption value (not needed for now).
                break;

            default: // Not 100% sure what these other ones are, but client isn't necessarily expecting anything back.
                reader.skipBytes(3);
                break;
        }
    }
}
