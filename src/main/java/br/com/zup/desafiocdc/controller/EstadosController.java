package br.com.zup.desafiocdc.controller;

import br.com.zup.desafiocdc.controller.requestdto.EstadoRequestDto;
import br.com.zup.desafiocdc.modelo.Estado;
import br.com.zup.desafiocdc.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadosController {

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequestDto estadoRequestDto) {

        Estado estado = estadoRequestDto.toModel();
        estadoRepository.save(estado);

        return ResponseEntity.ok().build();
    }

}
