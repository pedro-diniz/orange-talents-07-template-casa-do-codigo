package br.com.zup.desafiocdc.controller.requestdto;

import br.com.zup.desafiocdc.modelo.Autor;
import br.com.zup.desafiocdc.modelo.Categoria;
import br.com.zup.desafiocdc.modelo.Livro;
import br.com.zup.desafiocdc.validation.IdExists;
import br.com.zup.desafiocdc.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequestDto {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Length(max = 500)
    private String resumo;

    private String sumario;

    @Min(20)
    @NotNull
    private BigDecimal preco;

    @Min(100)
    @NotNull
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @NotNull
    @IdExists(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    @NotNull
    @IdExists(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    public Livro toModel() {

        return new Livro(
                titulo,
                resumo,
                sumario,
                preco,
                numeroPaginas,
                isbn,
                dataLancamento,
                new Autor(autorId),
                new Categoria((Long) categoriaId)
        );

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

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }
}
