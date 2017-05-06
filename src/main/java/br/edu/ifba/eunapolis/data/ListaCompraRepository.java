/**
 * 
 */
package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

	public List<ListaCompra> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ListaCompra> criteria = cb.createQuery(ListaCompra.class);
		Root<ListaCompra> listasCompras = criteria.from(ListaCompra.class);
		
		criteria.select(listasCompras).orderBy(cb.asc(listasCompras.get("nome")));
		return em.createQuery(criteria).getResultList();
	}
}
