package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

/**
 * @author Milan Rathod
 */
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    protected DatabaseConfiguration databaseConfiguration;

    @Override
    protected String getDatabaseName() {
        return databaseConfiguration.getDatabaseName();
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create();
    }
}
