package br.com.zup.desafiocdc.controller.requestdto;

import br.com.zup.desafiocdc.modelo.Estado;
import br.com.zup.desafiocdc.modelo.Pais;
import br.com.zup.desafiocdc.validation.IdExists;
import br.com.zup.desafiocdc.validation.EstadoValido;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoValido
public class EstadoRequestDto {

    @NotBlank
    private String nome;

    @NotNull
    @IdExists(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public EstadoRequestDto() {
    }

    public Estado toModel() {
        return new Estado(
                nome,
                new Pais(paisId)
        );
    }

}
