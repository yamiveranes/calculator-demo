package com.calculator.demo.integrationTest;

import com.calculator.demo.model.CalculatorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testAddition() {
        this.webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/calculator/add")
                                .queryParam("firstOperand", "9.8")
                                .queryParam("secondOperand", "2.3")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(CalculatorResponse.class)
                .consumeWith(r -> {
                    assertEquals(new CalculatorResponse("12.1"), r.getResponseBody());
                });
    }

    @Test
    public void testAdditionBadformat() {
        this.webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/calculator/add")
                                .queryParam("firstOperand", "9.*8")
                                .queryParam("secondOperand", "2.3")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    public void testSubstract() {
        this.webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/calculator/sub")
                                .queryParam("firstOperand", "9.8")
                                .queryParam("secondOperand", "2.3")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(CalculatorResponse.class)
                .consumeWith(r -> {
                    assertEquals(new CalculatorResponse("7.5"), r.getResponseBody());
                });
    }

    @Test
    public void testSubstractBadformat() {
        this.webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("/calculator/sub")
                                .queryParam("firstOperand", "9")
                                .queryParam("secondOperand", "2,3")
                                .build())
                .exchange()
                .expectStatus().isBadRequest();
    }


}