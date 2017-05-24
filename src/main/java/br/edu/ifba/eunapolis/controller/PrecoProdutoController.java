package br.edu.ifba.eunapolis.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.PrecoProduto;
import br.edu.ifba.eunapolis.model.Produto;

@Model
public class PrecoProdutoController extends Controller {

	@PostConstruct
	public void initNewPrecoProduto() {
		setNewPrecoProduto(new PrecoProduto());
	}

	public String menorPreco(Long id) {
		setListaPrecoProduto(new ArrayList<PrecoProduto>());
		setNewListaCompra(getListaCompraRepository().findById(id));
		
		for (Produto listaProduto : getNewListaCompra().getProdutos()) {
			setNewPrecoProduto(getPrecoProdutoRepository().produtoMaisBarato(listaProduto.getId()));
			if (getNewPrecoProduto() != null) {
				getListaPrecoProduto().add(getNewPrecoProduto());	
			}			
		}
		return "melhor_lista.jsf";
	}
	
	public String menorPrecoPorPontoVenda(Long id) {
		setListaPrecoProduto(new ArrayList<PrecoProduto>());
		setNewListaCompra(getListaCompraRepository().findById(id));
		List<Long> pvs = new ArrayList<>();
		pvs.add((long)1);
		pvs.add((long)0);
		for (Produto listaProduto : getNewListaCompra().getProdutos()) {
			setNewPrecoProduto((getPrecoProdutoRepository().produtoMaisBaratoPorPontoVenda(listaProduto.getId(),pvs)));
			if (getNewPrecoProduto() != null) {
				getListaPrecoProduto().add(getNewPrecoProduto());	
			}			
		}
		return "melhor_lista.jsf";
	}

	public void register() throws Exception {
		try {
			getPrecoProdutoRegistration().register(getNewPrecoProduto());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewPrecoProduto();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}

}
