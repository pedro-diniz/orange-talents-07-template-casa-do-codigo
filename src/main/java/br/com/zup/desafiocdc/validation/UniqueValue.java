package br.com.zup.desafiocdc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class) //
@Target({ElementType.FIELD}) // aplicável em atributos
@Retention(RetentionPolicy.RUNTIME) // pode ser lida em runtime na aplicação
public @interface UniqueValue {

    // Mensagem padrão aplicada quando a validação falhar
    String message() default "já está em uso";

    // Validação para validation groups. Pouco utilizada.
    Class<?>[] groups() default {};

    // Possibilidade de envio de informações extras. Pouco utilizada.
    Class<? extends Payload>[] payload() default{};

    // Nome do campo a ser validado
    String fieldName();

    // Nome da classe que contém o campo
    Class<?> domainClass();

}
