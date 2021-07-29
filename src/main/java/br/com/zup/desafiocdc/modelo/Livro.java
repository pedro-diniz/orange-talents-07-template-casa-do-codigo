package br.com.zup.desafiocdc.modelo;

/*
Necessidades
Um título, obrigatório e único
Um resumo do que vai ser encontrado no livro, obrigatório, no máximo 500 caracteres
Um sumário de tamanho livre. O texto deve entrar no formato markdown, que é uma string. Dessa forma ele pode ser formatado depois da maneira apropriada.
Preço do livro, obrigatório, no mínimo 20
Número de páginas, obrigatório, no mínimo 100
Isbn(identificador do livro), obrigatório, formato livre, e único
Data que ele deve entrar no ar(de publicação) (NO FUTURO)
Um livro pertence a uma categoria, que não pode ser nula
Um livro é de um autor, que não pode ser nulo

Resultado esperado
Um novo livro precisa ser criado e status 200 retornado
Caso alguma restrição não seja atendida, retorne 400 e um json informando os problemas de validação
 */

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Deprecated
    public Livro() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    @Column(columnDefinition = "TEXT")
    private String sumario;

    @Min(20)
    @NotNull
    private BigDecimal preco;

    @Min(100)
    @NotNull
    private Integer numeroPaginas;

    @NotBlank
    private String isbn;

    private LocalDate dataLancamento;

    @NotNull
    @ManyToOne
    private Autor autor;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, int numeroPaginas, String isbn, LocalDate dataLancamento, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
