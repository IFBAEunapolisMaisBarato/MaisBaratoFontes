package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.PrecoProduto;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction deprodutotion
@Stateless
public class PrecoProdutoRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<PrecoProduto> precoProdutoEventSrc;

    public void delete(PrecoProduto precoProduto) throws Exception {
		log.info("Deletando " + precoProduto.getId());
		em.remove(em.merge(precoProduto));
		precoProdutoEventSrc.fire(precoProduto);
	}

	public void update(PrecoProduto precoProduto) throws Exception {
		log.info("Atualizando " + precoProduto.getId());
		em.merge(precoProduto);

		precoProdutoEventSrc.fire(precoProduto);
	}

    public void register(PrecoProduto precoProduto) throws Exception {
        log.info("Registering " + precoProduto.getProduto().getNome());
        em.persist(precoProduto);
        precoProdutoEventSrc.fire(precoProduto);
    }
}
