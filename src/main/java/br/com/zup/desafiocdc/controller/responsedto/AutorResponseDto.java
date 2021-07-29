package br.com.zup.desafiocdc.controller.responsedto;

public class AutorResponseDto {

    private String nome;
    private String descricao;

    public AutorResponseDto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
