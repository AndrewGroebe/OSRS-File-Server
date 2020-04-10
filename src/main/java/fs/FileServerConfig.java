package fs;

import fs.cache.filestore.FileStore;
import io.vertx.core.json.JsonObject;

import java.io.IOException;

/**
 * Configuration related to this file server. All fields in this class are effectively constant (and are named as such)
 * because they should only ever be populated by Vert.x configuration.
 *
 * @author Andys1814.
 */
public final class FileServerConfig {

    public static String NAME;

    public static int PORT;

    public static int INSTANCES;

    public static int BUILD;

    public static FileStore FILESTORE;

    public static void load(JsonObject json) {
        NAME = json.getString("name");
        PORT = json.getInteger("port");
        INSTANCES = json.getInteger("instances");
        BUILD = json.getInteger("build");

        try {
            FILESTORE = new FileStore(json.getString("filestore"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
