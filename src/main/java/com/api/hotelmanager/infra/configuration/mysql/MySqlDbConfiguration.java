package com.api.hotelmanager.infra.configuration.mysql;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = SpringDataMysqlUserRepository.class)
public class MySqlDbConfiguration {
}
