package com.nemeros.conf;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="com.nemeros.jpa.repo")
@EntityScan(basePackages="com.nemeros.jpa.entity")
@EnableTransactionManagement
public class JpaConf {

}
