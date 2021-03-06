package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import br.edu.ifba.eunapolis.model.CategoriaProduto;

@ApplicationScoped
public class CategoriaProdutoRepository {

	@Inject
	private EntityManager em;

	public CategoriaProduto findById(Long id) {
		return em.find(CategoriaProduto.class, id);
	}

	public CategoriaProduto findByName(Long nome) {
		return em.find(CategoriaProduto.class, nome);
	}
	public List<CategoriaProduto> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CategoriaProduto> criteria = cb.createQuery(CategoriaProduto.class);
		Root<CategoriaProduto> categoriaProduto = criteria.from(CategoriaProduto.class);	
		criteria.select(categoriaProduto).orderBy(cb.asc(categoriaProduto.get("nome")));
		return em.createQuery(criteria).getResultList();
	}
	
}
