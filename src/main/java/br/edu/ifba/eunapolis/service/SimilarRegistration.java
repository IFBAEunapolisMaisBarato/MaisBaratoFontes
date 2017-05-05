/**
 * 
 */
package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.Similar;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;
/**
 * @author Jonathas
 * @version 1.0.0
 * @since 05/05/2017
 */

@Stateless
public class SimilarRegistration {
	
	@Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Similar> SimilarEventSrc;

    public void register(Similar similar) throws Exception {
        log.info("Registering " + similar.getId());
        em.persist(similar);
        SimilarEventSrc.fire(similar);
    }
}
