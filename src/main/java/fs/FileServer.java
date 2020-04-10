package fs;

import fs.handler.ConnectionHandler;
import fs.handler.HandshakeHandler;
import fs.handler.Session;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.net.NetServer;

/**
 * The starting point of this file server.
 *
 * @author Andys1814.
 */
public final class FileServer extends AbstractVerticle {

    private static final Logger logger = LoggerFactory.getLogger(FileServer.class);

    @Override
    public void start(Promise<Void> promise) {
        JsonObject config = config();
        FileServerConfig.load(config);

        // Vert.x does some magic here to allow us to scale this net server across multiple cores (loadbalanced between all instances).
        for (int i = 0; i < FileServerConfig.INSTANCES; i++) {
            NetServer server = vertx.createNetServer();

            server.connectHandler(socket -> {
                logger.info("New connection from: " + socket.remoteAddress());

                Session session = new Session(socket);
                socket.handler(new HandshakeHandler(socket));
            });

            server.listen(FileServerConfig.PORT, ar -> {
                if (ar.succeeded()) {
                    logger.info(FileServerConfig.NAME + " net server is now listening on port " + server.actualPort() + ".");
                } else {
                    promise.fail("Error encountered while attempting to initialize " + FileServerConfig.NAME + " file server.");
                }
            });
        }

        promise.complete();

    }

}
