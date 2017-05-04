package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.CategoriaProduto;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class CategoriaProdutoRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<CategoriaProduto> categoriaProdutoEventSrc;

    public void register(CategoriaProduto categoriaProduto) throws Exception {
        log.info("Registering " + categoriaProduto.getNome());
        em.persist(categoriaProduto);
        categoriaProdutoEventSrc.fire(categoriaProduto);
    }
}
