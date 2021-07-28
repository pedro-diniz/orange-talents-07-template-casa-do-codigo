package br.com.zup.desafiocdc.validation;

import br.com.zup.desafiocdc.controller.requestdto.CategoriaRequestDto;
import br.com.zup.desafiocdc.modelo.Autor;
import br.com.zup.desafiocdc.modelo.Categoria;
import br.com.zup.desafiocdc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeCategoriaDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override // define a classe suportada para validação
    public boolean supports(Class<?> aClass) {
        return CategoriaRequestDto.class.isAssignableFrom(aClass);
    }

    @Override // abriga a lógica de validação
    public void validate(Object o, Errors errors) {

        // para o método se a validação pelo @Valid não for bem-sucedida
        if (errors.hasErrors()) {
            return;
        }

        // converte o parâmetro para a classe do objeto a ser validado
        CategoriaRequestDto categoriaRequestDto = (CategoriaRequestDto) o;

        // busca a categoria a ser validada
        Optional<Categoria> categoriaDuplicada = categoriaRepository.findByNome(categoriaRequestDto.getNome());

        // retorna o erro à mensagem da exceção se já existir a categoria
        if (categoriaDuplicada.isPresent()) {
            errors.rejectValue("nome", null, "A categoria " +
                    categoriaRequestDto.getNome() + " já está em uso. Insira outra categoria.");
        }
    }
}
