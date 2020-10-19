package Application;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBClass {
    public static MongoClient client;
    public static MongoDatabase database;
    public static MongoCollection<User> usersCollection;
    public static MongoCollection<Equipment> equipmentCollection;
    public static MongoCollection<Reservation> reservationCollection;
    public static MongoCollection<Reclamation> reclamationCollection;
    public static MongoCollection<Review> reviewCollection;

    public static User currentSession = null;
    public static  User selectedUser= null;
    public static Equipment selectedEquipement = null;

    public static void Init() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb+srv://mounib:mmkkaa@cluster0-mk0io.mongodb.net/test?retryWrites=true&w=majority"))
                .codecRegistry(pojoCodecRegistry)
                .build();

        client = MongoClients.create(settings);
        database = client.getDatabase("PJava");
        usersCollection  = database.getCollection("Users", User.class);
        equipmentCollection = database.getCollection("Equipment", Equipment.class);
        reservationCollection = database.getCollection("Reservations", Reservation.class);
        reclamationCollection = database.getCollection("Reclamation", Reclamation.class);
        reviewCollection = database.getCollection("Review", Review.class);

    }
}
