package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.Orcamento;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class OrcamentoRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Orcamento> orcamentoEventSrc;

    public void register(Orcamento orcamento) throws Exception {
        log.info("Registering " + orcamento.getNome());
        em.persist(orcamento);
        orcamentoEventSrc.fire(orcamento);
    }
}
