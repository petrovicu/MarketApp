package com.klaymen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by petrovicu on 19/07/2018.
 */
@SpringBootApplication
public class SpringBootApplicationRunner extends SpringBootServletInitializer{

        public static void main(String[] args) throws Exception {
            SpringApplication.run(SpringBootApplicationRunner.class, args);
        }

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(SpringBootApplicationRunner.class);
        }
}
