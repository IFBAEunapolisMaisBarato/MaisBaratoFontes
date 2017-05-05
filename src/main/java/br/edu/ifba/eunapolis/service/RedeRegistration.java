/**
 * 
 */
package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.Rede;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

/**
 * @author Jonathas John
 * @version 1.0.0
 * @since 05/05/2017
 */

@Stateless
public class RedeRegistration {
	@Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Rede> RedeEventSrc;

    public void register(Rede rede) throws Exception {
        log.info("Registering " + rede.getNome());
        em.persist(rede);
        RedeEventSrc.fire(rede);
    }
}
