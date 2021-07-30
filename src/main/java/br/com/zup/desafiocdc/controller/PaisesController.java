package br.com.zup.desafiocdc.controller;

import br.com.zup.desafiocdc.controller.requestdto.EstadoRequestDto;
import br.com.zup.desafiocdc.controller.requestdto.PaisRequestDto;
import br.com.zup.desafiocdc.modelo.Pais;
import br.com.zup.desafiocdc.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisRequestDto paisRequestDto) {

        Pais pais = paisRequestDto.toModel();
        paisRepository.save(pais);

        return ResponseEntity.ok().build();
    }

}
