package com.polarbookshop.edgeservice.user;

import com.polarbookshop.edgeservice.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@Import(SecurityConfig.class)
public class UserControllerTests {


    @Autowired
    WebTestClient webClient;

    @MockBean
    ReactiveClientRegistrationRepository clientRegistrationRepository;

    @Test
    void whenNotAuthenticatedThen401(){
        webClient
                .get()
                .uri("/user")
                .exchange()
                .expectStatus().isUnauthorized();
    }
}
