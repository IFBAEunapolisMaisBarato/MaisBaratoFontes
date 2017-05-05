
package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import br.edu.ifba.eunapolis.model.PontoVenda;

@ApplicationScoped
public class PontoVendaRepository {

    @Inject
    private EntityManager em;

    public PontoVenda findById(Long id) {
        return em.find(PontoVenda.class, id);
    }

    public List<PontoVenda> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PontoVenda> criteria = cb.createQuery(PontoVenda.class);
        Root<PontoVenda> pontoVenda = criteria.from(PontoVenda.class);       
        criteria.select(pontoVenda).orderBy(cb.asc(pontoVenda.get("nome")));
        return em.createQuery(criteria).getResultList();
    }
}
