package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import br.edu.ifba.eunapolis.model.UnidadeMedida;

@ApplicationScoped
public class UnidadeMedidaRepository {

	@Inject
	private EntityManager em;

	public UnidadeMedida findById(Long id) {
		return em.find(UnidadeMedida.class, id);
	}

	public List<UnidadeMedida> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UnidadeMedida> criteria = cb.createQuery(UnidadeMedida.class);
		Root<UnidadeMedida> UnidadeMedida = criteria.from(UnidadeMedida.class);
		// Swap criteria statements if you would like to try out type-safe
		// criteria queries, a new
		// feature in JPA 2.0
		// criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		criteria.select(UnidadeMedida).orderBy(cb.asc(UnidadeMedida.get("nome")));
		return em.createQuery(criteria).getResultList();
	}
}
