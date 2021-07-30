package br.com.zup.desafiocdc.controller;

import br.com.zup.desafiocdc.controller.requestdto.ClienteRequestDto;
import br.com.zup.desafiocdc.modelo.Cliente;
import br.com.zup.desafiocdc.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteRequestDto clienteRequestDto) {

        Cliente cliente = clienteRequestDto.toModel();

        clienteRepository.save(cliente);

        return ResponseEntity.ok().body(cliente.toOutput());

    }
}
