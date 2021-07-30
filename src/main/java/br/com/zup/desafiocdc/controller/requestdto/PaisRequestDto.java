package br.com.zup.desafiocdc.controller.requestdto;

import br.com.zup.desafiocdc.modelo.Pais;
import br.com.zup.desafiocdc.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequestDto {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequestDto(String nome) {
        this.nome = nome;
    }

    public PaisRequestDto() {
    }

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
