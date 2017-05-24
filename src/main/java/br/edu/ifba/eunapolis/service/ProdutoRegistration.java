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

    public void delete(Produto produto) throws Exception {
		log.info("Deletando " + produto.getNome());
		em.remove(em.merge(produto));
		produtoEventSrc.fire(produto);
	}

	public void update(Produto produto) throws Exception {
		log.info("Atualizando " + produto.getNome());
		em.merge(produto);

		produtoEventSrc.fire(produto);
	}

    public void register(Produto produto) throws Exception {
        log.info("Registering " + produto.getNome());
        em.persist(produto);
        produtoEventSrc.fire(produto);
    }
}
