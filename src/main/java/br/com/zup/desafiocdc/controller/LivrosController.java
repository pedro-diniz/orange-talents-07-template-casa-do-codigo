package br.com.zup.desafiocdc.controller;

import br.com.zup.desafiocdc.controller.requestdto.LivroRequestDto;
import br.com.zup.desafiocdc.controller.responsedto.LivroDetalheResponseDto;
import br.com.zup.desafiocdc.controller.responsedto.LivroResponseDto;
import br.com.zup.desafiocdc.modelo.Livro;
import br.com.zup.desafiocdc.repository.AutorRepository;
import br.com.zup.desafiocdc.repository.CategoriaRepository;
import br.com.zup.desafiocdc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<LivroResponseDto> listar() {
        List<Livro> livros = livroRepository.findAll();
        List<LivroResponseDto> livrosResponse = new ArrayList<>();
        for (Livro livro: livros) {
            livrosResponse.add(livro.toOutput());
        }

        return livrosResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalheResponseDto> detalhar(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(livro.get().toDetail());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroRequestDto livroRequestDto) {

        Livro livro = livroRequestDto.toModel();
        livroRepository.save(livro);

        return ResponseEntity.ok().build();

    }

}
