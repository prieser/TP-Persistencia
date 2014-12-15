package nosqltp;

import java.net.UnknownHostException;

import net.vz.mongodb.jackson.JacksonDBCollection;
import nosqltp.model.Comentario;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class SistemDB {
    private static SistemDB INSTANCE;
    private MongoClient mongoClient;
    private DB db;

    synchronized public static SistemDB instance() {
        if (INSTANCE == null) {
            INSTANCE = new SistemDB();
        }
        return INSTANCE;
    }

    private SistemDB() {
        try {
            mongoClient = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        db = mongoClient.getDB("persistencia");
        
        collection(Comentario.class).getMongoCollection().ensureIndex("nombreComentador");
    }


    public <T> Collection<T> collection(Class<T> entityType) {
        DBCollection dbCollection = db.getCollection(entityType.getSimpleName());
        return new Collection<T>(JacksonDBCollection.wrap(dbCollection, entityType, String.class));
    }

}
