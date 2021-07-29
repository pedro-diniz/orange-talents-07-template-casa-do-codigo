package br.com.zup.desafiocdc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdExistsValidator.class) //
@Target({ElementType.FIELD}) // aplicável em atributos
@Retention(RetentionPolicy.RUNTIME) // pode ser lida em runtime na aplicação
public @interface IdExists {

    // Mensagem padrão aplicada quando a validação falhar
    String message() default "objeto com esse id não existe";

    // Validação para validation groups. Pouco utilizada.
    Class<?>[] groups() default {};

    // Possibilidade de envio de informações extras. Pouco utilizada.
    Class<? extends Payload>[] payload() default{};

    // Nome do campo a ser validado
    String fieldName();

    // Nome da classe que contém o campo
    Class<?> domainClass();

}
