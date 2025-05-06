package com.example.consolesAPI.entities;


import com.example.consolesAPI.dto.ConsolesDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_consoles")
public class Consoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int ano;
    private String descricao;
    private boolean favoritar;
    private String urlImg;

    public Consoles(ConsolesDTO dados) {
        nome = dados.nome();
        ano = dados.ano();
        descricao = dados.descricao();
        favoritar = dados.favoritar();
        urlImg = dados.urlImg();
    }

    public Consoles(Long id, String nome, int ano, String descricao, boolean favoritar, String urlImg) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.descricao = descricao;
        this.favoritar = favoritar;
        this.urlImg = urlImg;
    }

    public Consoles() {
    }

    //GET
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAno() {
        return ano;
    }

    public boolean getfavoritar(){
        return favoritar;
    }

    public String getUrlImg(){
        return urlImg;
    }

    //SET
    public void setId(Long id) {
        this.id = id;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFavoritar(boolean favoritar) {
        this.favoritar = favoritar;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

}
