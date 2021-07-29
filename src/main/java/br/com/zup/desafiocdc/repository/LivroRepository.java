package br.com.zup.desafiocdc.repository;

import br.com.zup.desafiocdc.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
