package br.com.zup.desafiocdc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EstadoObrigatorioValidator.class) //
@Target({ElementType.TYPE}) // aplicável em atributos
@Retention(RetentionPolicy.RUNTIME) // pode ser lida em runtime na aplicação
public @interface EstadoObrigatorio {
    // Mensagem padrão aplicada quando a validação falhar
    String message() default "estado não foi selecionado ou não existe. Selecione um estado válido";

    // Validação para validation groups. Pouco utilizada.
    Class<?>[] groups() default {};

    // Possibilidade de envio de informações extras. Pouco utilizada.
    Class<? extends Payload>[] payload() default{};
}
