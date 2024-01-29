package com.spring.playerapi.config;

import com.spring.playerapi.model.Player;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class SpringConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
       // RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] preventMethod={HttpMethod.GET,HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE};
        config.getExposureConfiguration()
                .forDomainType(Player.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod));
    }
}
