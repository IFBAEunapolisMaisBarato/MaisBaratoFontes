/**
 * 
 */
package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.ListaCompra;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * @author Jonathas John
 * @version 1.0.1
 * @since 05/05/2017
 */

@Stateless
public class ListaCompraRegistration {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	@Inject
	private Event<ListaCompra> listaCompraEventSrc;

	public void delete(ListaCompra listaCompra) throws Exception {
		log.info("Deletando " + listaCompra.getNome());
		em.remove(em.merge(listaCompra));
		listaCompraEventSrc.fire(listaCompra);
	}

	public void update(ListaCompra listaCompra) throws Exception {
		log.info("Atualizando " + listaCompra.getNome());
		em.merge(listaCompra);

		listaCompraEventSrc.fire(listaCompra);
	}

	public void register(ListaCompra listaCompra) throws Exception {
		log.info("Registering " + listaCompra.getId());
		em.persist(listaCompra);
		listaCompraEventSrc.fire(listaCompra);
	}

	public void addProdutos(ListaCompra listaCompra) {
		log.info("Registering " + listaCompra.getId());
		em.merge(listaCompra);
		listaCompraEventSrc.fire(listaCompra);
	}
}
