package io.korconut.junittest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.korconut.junittest.config.DBConfig;

@Configuration
@ComponentScan(basePackages = { "io.korconut.junittest.dao", "io.korconut.junittest.service", "io.korconut.junittest.envi" })
@Import({ DBConfig.class })
public class ApplicationConfig {

}
