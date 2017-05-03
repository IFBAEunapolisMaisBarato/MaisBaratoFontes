package br.edu.ifba.eunapolis.service;

import br.edu.ifba.eunapolis.model.Marca;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class MarcaRegistration {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<Marca> marcaEventSrc;

    public void register(Marca marca) throws Exception {
        log.info("Registering " + marca.getNome());
        em.persist(marca);
        marcaEventSrc.fire(marca);
    }
}
