package br.com.zup.desafiocdc.controller.requestdto;

import br.com.zup.desafiocdc.modelo.Categoria;
import br.com.zup.desafiocdc.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequestDto {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
