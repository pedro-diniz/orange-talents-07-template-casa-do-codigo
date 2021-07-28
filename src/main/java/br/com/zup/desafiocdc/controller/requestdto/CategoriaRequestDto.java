package br.com.zup.desafiocdc.controller.requestdto;

import br.com.zup.desafiocdc.modelo.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequestDto {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
