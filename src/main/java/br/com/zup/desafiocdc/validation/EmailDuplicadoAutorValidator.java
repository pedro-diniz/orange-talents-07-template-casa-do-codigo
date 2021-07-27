package br.com.zup.desafiocdc.validation;

import br.com.zup.desafiocdc.controller.requestdto.AutorRequestDto;
import br.com.zup.desafiocdc.exception.ApiValidationException;
import br.com.zup.desafiocdc.modelo.Autor;
import br.com.zup.desafiocdc.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override // define a classe suportada para validação
    public boolean supports(Class<?> aClass) {
        return AutorRequestDto.class.isAssignableFrom(aClass);
    }

    @Override // abriga a lógica de validação
    public void validate(Object o, Errors errors) {

        // para o método se a validação pelo @Valid não for bem-sucedida
        if(errors.hasErrors()) {
            return;
        }

        // converte o parâmetro para a classe do objeto a ser validado
        AutorRequestDto autorRequestDto = (AutorRequestDto) o;

        // busca o e-mail a ser validado
        Optional<Autor> emailDuplicado = autorRepository.findByEmail(autorRequestDto.getEmail());

        // retorna o erro se o e-mail já estiver em uso
        if(emailDuplicado.isPresent()) {
            errors.rejectValue("email", null, "O e-mail " +
                    autorRequestDto.getEmail() + " já está em uso. Insira outro e-mail.");
            throw new ApiValidationException("E-mail em uso");
        }

    }
}
