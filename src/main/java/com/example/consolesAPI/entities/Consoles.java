package com.example.consolesAPI.entities;

import com.example.consolesAPI.dto.ConsolesDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tb_consoles")
@Schema(description = "Entidade que representa um console de videogame")
public class Consoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do console", example = "1")
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    @Schema(description = "Nome do console", example = "PlayStation 5")
    private String nome;

    @Min(value = 1970, message = "Ano mínimo permitido é 1970")
    @Max(value = 2100, message = "Ano máximo permitido é 2100")
    @Schema(description = "Ano de lançamento do console", example = "2020")
    private int ano;

    @NotBlank(message = "Descrição não pode estar vazia")
    @Size(max = 255, message = "Descrição pode ter no máximo 255 caracteres")
    @Schema(description = "Descrição do console", example = "Console da nova geração da Sony com SSD ultra rápido")
    private String descricao;

    @Min(1)
    @Max(5)
    @Schema(description = "Avaliação do console (1 a 5 estrelas)", example = "5")
    private int avaliacao;

    @NotBlank(message = "URL da imagem é obrigatória")
    @Schema(description = "URL da imagem representando o console", example = "https://exemplo.com/imagem.jpg")
    private String urlImg;

    @Column(name = "favorito")
    private boolean favorito = false;


    public Consoles() {
    }

    public Consoles(ConsolesDTO dados) {
        this.nome = dados.nome();
        this.ano = dados.ano();
        this.descricao = dados.descricao();
        this.avaliacao = dados.avaliacao();
        this.urlImg = dados.urlImg();
    }

    public Consoles(Long id, String nome, int ano, String descricao, String urlImg, int avaliacao) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.descricao = descricao;
        this.urlImg = urlImg;
        this.avaliacao = avaliacao;
    }

    // Getters e Setters (pode substituir por Lombok se preferir)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

}

