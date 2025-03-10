package br.com.zup.desafiocdc.controller;

import br.com.zup.desafiocdc.controller.requestdto.AutorRequestDto;
import br.com.zup.desafiocdc.modelo.Autor;
import br.com.zup.desafiocdc.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping // apesar de não ter sido solicitado, foi criado para testar a exibição de registros
    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorRequestDto autorRequestDto) {

        Autor autor = autorRequestDto.toModel();
        autorRepository.save(autor);

        return ResponseEntity.ok().build();

    }

}
