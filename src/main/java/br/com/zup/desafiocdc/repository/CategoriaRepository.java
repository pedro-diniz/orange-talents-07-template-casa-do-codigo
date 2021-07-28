package br.com.zup.desafiocdc.repository;

import br.com.zup.desafiocdc.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);

}
