package br.com.zup.desafiocdc.repository;

import br.com.zup.desafiocdc.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
