package fs.handler;

import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetSocket;

public final class Session {

    private final NetSocket socket;

    private Handler<Buffer> handler;

    public Session(NetSocket socket) {
        this.socket = socket;
    }

    public void setHandler(Handler<Buffer> handler) {
        this.handler = handler;
    }

}
