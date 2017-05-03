package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.UnidadeMedida;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction deprodutotion
@Stateless
public class UnidadeMedidaRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<UnidadeMedida> unidadeMedidaEventSrc;

    public void register(UnidadeMedida unidadeMedida) throws Exception {
        log.info("Registering " + unidadeMedida.getNome());
        em.persist(unidadeMedida);
        unidadeMedidaEventSrc.fire(unidadeMedida);
    }
}
