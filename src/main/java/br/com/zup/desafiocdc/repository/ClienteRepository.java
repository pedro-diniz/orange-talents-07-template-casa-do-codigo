package br.com.zup.desafiocdc.repository;

import br.com.zup.desafiocdc.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
