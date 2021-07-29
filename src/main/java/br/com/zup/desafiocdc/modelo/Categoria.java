package br.com.zup.desafiocdc.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    public Categoria() {}

    // construtor para uso do Livro
    public Categoria(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

}
