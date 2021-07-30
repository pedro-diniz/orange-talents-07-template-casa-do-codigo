package br.com.zup.desafiocdc.validation;

import br.com.zup.desafiocdc.controller.requestdto.EstadoRequestDto;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoValidoValidator implements ConstraintValidator<EstadoValido, EstadoRequestDto> {

    // não conseguimos utilizar Repository aqui, pois a injeção seria dinâmica
    // acabaríamos precisando passar o Repository por parâmetro também, e
    // queremos simplificar o código
    @PersistenceContext
    private EntityManager entityManager;

    @Override // instancia o objeto de validação
    public void initialize(EstadoValido toValidate) {}

    @Override // faz uma query a partir dos parâmetros recebidos
    public boolean isValid(EstadoRequestDto value, ConstraintValidatorContext validatorContext) {

        Query query = entityManager.createQuery("select i from Estado i where nome = :nomeEstado " +
                " and pais_id = :paisId");

        // configuração do parâmetro da query
        query.setParameter("nomeEstado", value.getNome());
        query.setParameter("paisId", value.getPaisId());

        // criação de uma lista com os resultados da query
        List<?> list = query.getResultList();

        // mensagem de exceção para a condição de a lista ter mais de um registro
        Assert.state(list.size() <= 1, "Foi encontrado mais de um estado :nomeEstado neste país");

        // retorno do booleano se a lista está vazia ou não, validando a requisição
        return list.isEmpty();
    }

}
