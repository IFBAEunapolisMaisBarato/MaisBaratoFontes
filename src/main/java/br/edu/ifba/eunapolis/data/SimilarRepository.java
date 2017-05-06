package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import br.edu.ifba.eunapolis.model.Similar;

@ApplicationScoped
public class SimilarRepository {

	@Inject
	private EntityManager em;

	public Similar findById(Long id) {
		return em.find(Similar.class, id);
	}

	public List<Similar> findAllOrderedById() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Similar> criteria = cb.createQuery(Similar.class);
		Root<Similar> similar = criteria.from(Similar.class);
		// Swap criteria statements if you would like to try out type-safe
		// criteria queries, a new
		// feature in JPA 2.0
		// criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		criteria.select(similar).orderBy(cb.asc(similar.get("id")));
		return em.createQuery(criteria).getResultList();
	}
}
