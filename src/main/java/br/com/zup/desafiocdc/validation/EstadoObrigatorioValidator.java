package br.com.zup.desafiocdc.validation;

import br.com.zup.desafiocdc.controller.requestdto.ClienteRequestDto;
import br.com.zup.desafiocdc.modelo.Estado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoObrigatorioValidator implements ConstraintValidator<EstadoObrigatorio, ClienteRequestDto> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(EstadoObrigatorio constraintAnnotation) {}

    @Override
    public boolean isValid(ClienteRequestDto value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("select e from Estado e where pais_id = :paisId");

        query.setParameter("paisId", value.getPaisId());

        List<Estado> list = query.getResultList();

        // País não tem Estados
        if (list.isEmpty()) {
            return true;
        }
        // País tem Estados
        else {

            // Verifica se o estado informado pertence ao país informado.
            for (Estado estado: list) {
                if (estado.getId() == value.getEstadoId()) {
                    return true;
                }
            }

            return false;
        }

    }
}
