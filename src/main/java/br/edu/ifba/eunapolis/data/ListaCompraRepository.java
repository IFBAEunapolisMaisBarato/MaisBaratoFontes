/**
 * 
 */
package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import br.edu.ifba.eunapolis.model.ListaCompra;

/**
 * @author Jonathas John
 * @version 1.0.0
 * @since 06/05/2017
 *
 */

@ApplicationScoped
public class ListaCompraRepository {
	@Inject
	private EntityManager em;

	public ListaCompra findById(Long id) {
		return em.find(ListaCompra.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<ListaCompra> findAllOrderedByName() {
		Query query = em.createNamedQuery("ListaCompra.consultarTodos");
		return query.getResultList();
	}
}
