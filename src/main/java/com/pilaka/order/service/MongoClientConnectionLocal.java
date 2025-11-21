package com.pilaka.order.service;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoClientConnectionLocal {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://apilaka9:saibaba@cluster0.3de2w.mongodb.net/?appName=Cluster0";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }

        createTestDocument();
    }

    static void createTestDocument() {

        String connectionString = "mongodb+srv://apilaka9:saibaba@cluster0.3de2w.mongodb.net/?appName=Cluster0";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            // Select database
            MongoDatabase database = mongoClient.getDatabase("sampleDB");

            // Select collection
            MongoCollection<Document> collection = database.getCollection("users");

            // Create sample document
            Document doc = new Document("name", "Pilaka Ananta")
                    .append("email", "apilaka@yahoo.ca")
                    .append("age", 72)
                    .append("active", true)
                    .append("address", new Document("city", "Glen Allen")
                            .append("zip", 23060));

            // Insert into MongoDB
            collection.insertOne(doc);

            System.out.println("Document inserted successfully!");
        }
    }
}
