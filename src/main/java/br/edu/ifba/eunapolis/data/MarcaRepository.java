package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import br.edu.ifba.eunapolis.model.Marca;

@ApplicationScoped
public class MarcaRepository {

	@Inject
	private EntityManager em;

	public Marca findById(Long id) {
		return em.find(Marca.class, id);
	}

	public List<Marca> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Marca> criteria = cb.createQuery(Marca.class);
		Root<Marca> marca = criteria.from(Marca.class);
		criteria.select(marca).orderBy(cb.asc(marca.get("nome")));
		return em.createQuery(criteria).getResultList();
	}
}
