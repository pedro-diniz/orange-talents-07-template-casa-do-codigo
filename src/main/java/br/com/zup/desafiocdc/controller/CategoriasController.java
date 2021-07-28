package br.com.zup.desafiocdc.controller;

import br.com.zup.desafiocdc.controller.requestdto.CategoriaRequestDto;
import br.com.zup.desafiocdc.modelo.Categoria;
import br.com.zup.desafiocdc.repository.CategoriaRepository;
import br.com.zup.desafiocdc.validation.NomeCategoriaDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private NomeCategoriaDuplicadoValidator nomeCategoriaDuplicadoValidator;

    @InitBinder
    private void init (WebDataBinder webDataBinder) {
        webDataBinder.addValidators(nomeCategoriaDuplicadoValidator);
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequestDto categoriaRequestDto) {

        Categoria categoria = categoriaRequestDto.toModel();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().build();
    }

}
