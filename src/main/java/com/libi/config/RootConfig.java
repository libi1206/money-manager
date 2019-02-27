package com.libi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author libi
 */
@Configuration
@ComponentScan(basePackages = "com.libi")
@Import({DataBaseConfig.class,AspectConfig.class})
public class RootConfig {
}
