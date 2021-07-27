package br.com.zup.desafiocdc.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problema {

    private Integer status;
    private Instant dataHora;
    private String titulo;
    private List<Campo> campos;

    public Problema(Integer status, Instant dataHora, String titulo) {
        this.status = status;
        this.dataHora = dataHora;
        this.titulo = titulo;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public Integer getStatus() {
        return status;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Campo> getCampos() {
        return campos;
    }
}
