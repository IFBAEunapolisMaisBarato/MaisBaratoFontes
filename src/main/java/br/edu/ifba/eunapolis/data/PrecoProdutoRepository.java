/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.edu.ifba.eunapolis.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import br.edu.ifba.eunapolis.model.PrecoProduto;

@ApplicationScoped
public class PrecoProdutoRepository {

	@Inject
	private EntityManager em;

	public PrecoProduto findById(Long id) {
		return em.find(PrecoProduto.class, id);
	}

	public List<PrecoProduto> findAllOrderedById() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PrecoProduto> criteria = cb.createQuery(PrecoProduto.class);
		Root<PrecoProduto> precoProduto = criteria.from(PrecoProduto.class);
		criteria.select(precoProduto).orderBy(cb.asc(precoProduto.get("id")));
		return em.createQuery(criteria).getResultList();
	}

	public PrecoProduto produtoMaisBarato(Long id) {
		Query query = em.createNamedQuery("PrecoProduto.menorPrecoProduto");
		query.setParameter("id", id);		
		PrecoProduto menor;
		try {
			menor = (PrecoProduto) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return  menor;
	}
}
