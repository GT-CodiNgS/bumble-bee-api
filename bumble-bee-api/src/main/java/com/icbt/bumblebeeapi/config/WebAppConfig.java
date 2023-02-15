package com.icbt.bumblebeeapi.config;
/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/2/2023
 */
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class WebAppConfig {
   @Bean
   public ModelMapper modelMapper() {
       return new ModelMapper();
   }

   
}
