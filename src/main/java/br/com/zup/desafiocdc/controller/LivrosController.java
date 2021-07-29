package br.com.zup.desafiocdc.controller;

import br.com.zup.desafiocdc.controller.requestdto.LivroRequestDto;
import br.com.zup.desafiocdc.modelo.Livro;
import br.com.zup.desafiocdc.repository.AutorRepository;
import br.com.zup.desafiocdc.repository.CategoriaRepository;
import br.com.zup.desafiocdc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroRequestDto livroRequestDto) {

        Livro livro = livroRequestDto.toModel();
        livroRepository.save(livro);

        return ResponseEntity.ok().build();

    }

}
