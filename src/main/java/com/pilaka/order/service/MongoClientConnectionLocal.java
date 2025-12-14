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

        createTestDocument();

    }

    static void createTestDocument() {

        String connectionString = "mongodb://admin:secret123@localhost:27017/orderdb?authSource=admin";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            // Select database
            MongoDatabase database = mongoClient.getDatabase("orderdb");

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
