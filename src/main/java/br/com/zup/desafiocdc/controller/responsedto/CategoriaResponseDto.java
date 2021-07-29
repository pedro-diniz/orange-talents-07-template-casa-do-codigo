package br.com.zup.desafiocdc.controller.responsedto;

public class CategoriaResponseDto {

    private String nome;

    public CategoriaResponseDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
