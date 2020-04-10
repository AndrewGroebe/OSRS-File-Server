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
public final class HandshakeHandler implements Handler<Buffer> {

    private final NetSocket socket;

    public HandshakeHandler(NetSocket socket) {
        this.socket = socket;
    }

    @Override
    public void handle(Buffer buffer) {
        BufferReader reader = new BufferReader(buffer.getBytes());

        int opcode = reader.getUnsignedByte();
        if (opcode != 15) {
            socket.close(); // Unhandled opcode.
        }

        BufferWriter writer = new BufferWriter();
        int build = reader.getUnsignedInt();
        if (build != FileServerConfig.BUILD) {
            writer.put(6); // Response mismatch
        } else {
            writer.put(0); // Response OK
        }

        socket.write(writer.getBuffer());
        socket.handler(new ConnectionHandler(socket));
    }
}
