package com.example.consolesAPI.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ConsolesDTO(
        @Schema(description = "Nome do Console", example = "PS4")
        String nome,

        @Schema(description = "Ano do Videogame", example = "2015")
        int ano,

        @Schema(description = "Descrição", example = "O ps4 foi um videogame...")
        String descricao,

        @Schema(description = "Avaliação do Console", example = "4")
        int avaliacao,

        @Schema(description = "Url Imagem", example = "aaaa.jpg")
        String urlImg) {
}
