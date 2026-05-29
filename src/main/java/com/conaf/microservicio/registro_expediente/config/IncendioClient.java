package com.conaf.microservicio.registro_expediente.config;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class IncendioClient {

    private final WebClient webClient;

    public IncendioClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://localhost:8081")
                .build();
    }

    public Boolean existeIncendio(Long idIncendio) {
        return webClient.get()
                .uri("/api/v1/incendios/{id}/exists", idIncendio)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
