package br.com.avaliacao.assembleia.votacao.infrastructure.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.avaliacao.assembleia.votacao.infrastructure.repository.mongo")
@EnableTransactionManagement
public class MongoConfig extends AbstractMongoClientConfiguration {

  @Value("${db.config.uri}")
  private String uri;

  @Value("${db.config.database}")
  private String db;

  @Override
  protected String getDatabaseName() {
    return db;
  }

  @Override
  public MongoClient mongoClient() {
    return MongoClients.create(uri);
  }

  @Bean
  public MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
    return new MongoTransactionManager(dbFactory);
  }

}