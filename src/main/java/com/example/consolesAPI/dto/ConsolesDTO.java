package com.example.consolesAPI.dto;

public record ConsolesDTO(String nome,
                          int ano,
                          String descricao,
                          boolean favoritar,
                          String urlImg) {
}
