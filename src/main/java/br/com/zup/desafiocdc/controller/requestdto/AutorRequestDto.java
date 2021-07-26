package br.com.zup.desafiocdc.controller.requestdto;

import br.com.zup.desafiocdc.modelo.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AutorRequestDto {

    @Email
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    @Length(max = 400)
    private String descricao;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toEntity() {
        return new Autor(email, nome, descricao);
    }
}
