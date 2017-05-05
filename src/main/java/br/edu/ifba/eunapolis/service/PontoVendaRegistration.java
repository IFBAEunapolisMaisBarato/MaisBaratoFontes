package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.PontoVenda;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction deprodutotion
@Stateless
public class PontoVendaRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<PontoVenda> pontoVendaEventSrc;

    public void register(PontoVenda pontoVenda) throws Exception {
        log.info("Registering " + pontoVenda.getNome());
        em.persist(pontoVenda);
        pontoVendaEventSrc.fire(pontoVenda);
    }
}
