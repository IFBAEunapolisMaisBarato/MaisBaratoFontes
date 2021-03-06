/**
 * 
 */
package br.edu.ifba.eunapolis.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifba.eunapolis.controller.Authenticator;
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

	@Inject
	Authenticator auth;
	
	public ListaCompra findById(Long id) {
		return em.find(ListaCompra.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ListaCompra> findAllOrderedByName() {
		Query query = em.createNamedQuery("ListaCompra.consultarPorUsuario");
		query.setParameter("fbId", auth.getProfile().getValidatedId());
		return query.getResultList();
	}
	
}
