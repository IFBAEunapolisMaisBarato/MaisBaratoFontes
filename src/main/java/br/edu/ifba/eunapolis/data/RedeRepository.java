package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import br.edu.ifba.eunapolis.model.Rede;


/**
 * @author Michael Rocha
 * @version 1.0.0
 * @since 04/05/2017
 *
 */

@ApplicationScoped
public class RedeRepository {

	@Inject
	private EntityManager em;

	public Rede findById(Long id) {
		return em.find(Rede.class, id);
	}

	public List<Rede> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Rede> criteria = cb.createQuery(Rede.class);
		Root<Rede> redes = criteria.from(Rede.class);
		// Swap criteria statements if you would like to try out type-safe
		// criteria queries, a new
		// feature in JPA 2.0
		// criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		criteria.select(redes).orderBy(cb.asc(redes.get("nome")));
		return em.createQuery(criteria).getResultList();
	}
}
