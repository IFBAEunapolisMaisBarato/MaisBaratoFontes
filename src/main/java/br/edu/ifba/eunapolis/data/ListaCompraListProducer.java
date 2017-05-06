/**
 * 
 */
package br.edu.ifba.eunapolis.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import br.edu.ifba.eunapolis.model.ListaCompra;

/**
 * @author Jonathas John
 * @version 1.0.0
 * @since 06/05/2017
 *
 */

@RequestScoped
public class ListaCompraListProducer {

    @Inject
    private ListaCompraRepository listaCompraRepository;

    private List<ListaCompra> listasCompras;

    
    
    @Produces
    @Named
    public List<ListaCompra> getListasCompras() {
        return listasCompras;
    }

    public void onRedeListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final ListaCompra listasCompras) {
        retrieveAllRedesOrderedByName();
    }

    @PostConstruct
    public void retrieveAllRedesOrderedByName() {
    	listasCompras = listaCompraRepository.findAllOrderedByName();
    }
}
