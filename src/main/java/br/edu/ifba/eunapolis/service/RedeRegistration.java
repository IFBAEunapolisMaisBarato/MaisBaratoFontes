package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.Rede;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * @author Michael Rocha
 * @version 1.0.0
 * @since 04/05/2017
 *
 */

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class RedeRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Rede> redeEventSrc;
    
    public void delete(Rede rede) throws Exception {
		log.info("Deletando " + rede.getNome());
		em.remove(em.merge(rede));
		redeEventSrc.fire(rede);
	}

	public void update(Rede rede) throws Exception {
		log.info("Atualizando " + rede.getNome());
		em.merge(rede);

		redeEventSrc.fire(rede);
	}

    public void register(Rede rede) throws Exception {
        log.info("Registering " + rede.getNome());
        em.persist(rede);
        redeEventSrc.fire(rede);
    }
}
