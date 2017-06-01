package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import br.edu.ifba.eunapolis.model.Orcamento;

@ApplicationScoped
public class OrcamentoRepository {

	@Inject
	private EntityManager em;

	public Orcamento findById(Long id) {
		return em.find(Orcamento.class, id);
	}

	public List<Orcamento> findAllOrderedById() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Orcamento> criteria = cb.createQuery(Orcamento.class);
		Root<Orcamento> orcamento = criteria.from(Orcamento.class);
		// Swap criteria statements if you would like to try out type-safe
		// criteria queries, a new
		// feature in JPA 2.0
		// criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
		criteria.select(orcamento).orderBy(cb.asc(orcamento.get("id")));
		return em.createQuery(criteria).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orcamento> findAllOrcamentos(Long id) {
		Query query = em.createNamedQuery("Orcamento.consultarPorLista");
		query.setParameter("listaId", id);
		return query.getResultList();
	}
}
