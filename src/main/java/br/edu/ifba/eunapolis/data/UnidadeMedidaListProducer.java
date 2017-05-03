package br.edu.ifba.eunapolis.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import br.edu.ifba.eunapolis.model.UnidadeMedida;

@RequestScoped
public class UnidadeMedidaListProducer {

    @Inject
    private UnidadeMedidaRepository unidadeMedidaRepository;

    private List<UnidadeMedida> unidadeMedidas;

    // @Named provides access the return value via the EL variable name "marcas" in the UI (e.g.
    // Facelets or JSP view)
    @Produces
    @Named
    public List<UnidadeMedida> getUnidadeMedidas() {
        return unidadeMedidas;
    }

    public void onUnidadeMedidaListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final UnidadeMedida unidadeMedida) {
        retrieveAllunidadeMedidaOrderedByName();
    }

    @PostConstruct
    public void retrieveAllunidadeMedidaOrderedByName() {
        unidadeMedidas = unidadeMedidaRepository.findAllOrderedByName();
    }
}
