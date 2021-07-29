package br.com.zup.desafiocdc.controller.responsedto;

public class LivroResponseDto {

    private Long id;
    private String titulo;

    public LivroResponseDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
