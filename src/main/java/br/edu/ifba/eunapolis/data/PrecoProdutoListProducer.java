
package br.edu.ifba.eunapolis.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import br.edu.ifba.eunapolis.model.PrecoProduto;

@RequestScoped
public class PrecoProdutoListProducer {

    @Inject
    private PrecoProdutoRepository precoProdutoRepository;

    private List<PrecoProduto> precoProdutos;

    // @Named provides access the return value via the EL variable name "precoProdutos" in the UI (e.g.
    // Facelets or JSP view)
    @Produces
    @Named
    public List<PrecoProduto> getPrecoProdutos() {
        return precoProdutos;
    }

    public void onPrecoProdutoListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final PrecoProduto precoProduto) {
        retrieveAllPrecoProdutosOrderedById();
    }

    @PostConstruct
    public void retrieveAllPrecoProdutosOrderedById() {
        precoProdutos = precoProdutoRepository.findAllOrderedById();
    }
}
