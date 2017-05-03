package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.Produto;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction deprodutotion
@Stateless
public class ProdutoRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Produto> produtoEventSrc;

    public void register(Produto produto) throws Exception {
        log.info("Registering " + produto.getNome());
        em.persist(produto);
        produtoEventSrc.fire(produto);
    }
}
