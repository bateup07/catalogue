package com.barclays.api.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author matthewbateup
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.barclays.api.domain"})
@EnableJpaRepositories(basePackages = {"com.barclays.api.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
