package br.com.zup.desafiocdc.controller.responsedto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroDetalheResponseDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private AutorResponseDto autor;
    private CategoriaResponseDto categoria;
    private LocalDate dataLancamento;
    private Integer numeroPaginas;
    private String isbn;

    public LivroDetalheResponseDto(String titulo, String resumo, String sumario, BigDecimal preco,
                                   AutorResponseDto autor, CategoriaResponseDto categoria, LocalDate dataLancamento,
                                   Integer numeroPaginas, String isbn) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.autor = autor;
        this.categoria = categoria;
        this.dataLancamento = dataLancamento;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
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

    public AutorResponseDto getAutor() {
        return autor;
    }

    public CategoriaResponseDto getCategoria() {
        return categoria;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

}
