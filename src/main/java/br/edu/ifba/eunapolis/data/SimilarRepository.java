package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import br.edu.ifba.eunapolis.controller.Authenticator;
import br.edu.ifba.eunapolis.model.Similar;

@ApplicationScoped
public class SimilarRepository {

	@Inject
	private EntityManager em;
	
	@Inject
	Authenticator auth;

	public Similar findById(Long id) {
		return em.find(Similar.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Similar> findAllByUser() {
		Query query = em.createNamedQuery("Similar.consultarTodosPorUsuario");
		query.setParameter("fbId", auth.getProfile().getValidatedId());
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Similar findByProdutoOrigem(Long produtoOrigem) {
		Query query = em.createNamedQuery("Similar.consultarPorUsuarioProdutoId");
		query.setParameter("fbId", auth.getProfile().getValidatedId());
		query.setParameter("produtoOrigemId", produtoOrigem);
		try {
			return (Similar) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
