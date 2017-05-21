package br.edu.ifba.eunapolis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import br.edu.ifba.eunapolis.data.PrecoProdutoRepository;
import br.edu.ifba.eunapolis.model.ListaCompra;
import br.edu.ifba.eunapolis.model.PrecoProduto;
import br.edu.ifba.eunapolis.model.Produto;
import br.edu.ifba.eunapolis.service.PrecoProdutoRegistration;

@Model
public class PrecoProdutoController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private PrecoProdutoRegistration precoProdutoRegistration;

	@Inject
	private PrecoProdutoRepository precoProdutoRepository;

	@Inject
	private ListaCompraController listaCompraController;

	@Produces
	@Named
	private PrecoProduto newPrecoProduto;

	@Produces
	@Named
	private List<PrecoProduto> listaPrecoProduto = new ArrayList<>();

	@Produces
	@Named
	private ListaCompra listaCompra;

	@PostConstruct
	public void initNewPrecoProduto() {
		newPrecoProduto = new PrecoProduto();
	}

	public String menorPreco(Long id) {
		listaCompra = listaCompraController.findById(id);
		
		for (Produto listaProduto : listaCompra.getProdutos()) {
			newPrecoProduto =precoProdutoRepository.produtoMaisBarato(listaProduto.getId());
			if (newPrecoProduto != null) {
				listaPrecoProduto.add(newPrecoProduto);	
			}			
		}
		return "melhor_lista.jsf";
	}
	
	public String menorPrecoPorPontoVenda(Long id) {
		listaCompra = listaCompraController.findById(id);
		List<Long> pvs = new ArrayList<>();
		pvs.add((long)1);
		pvs.add((long)0);
		for (Produto listaProduto : listaCompra.getProdutos()) {
			newPrecoProduto =precoProdutoRepository.produtoMaisBaratoPorPontoVenda(listaProduto.getId(),pvs);
			if (newPrecoProduto != null) {
				listaPrecoProduto.add(newPrecoProduto);	
			}			
		}
		return "melhor_lista.jsf";
	}

	public void register() throws Exception {
		try {
			precoProdutoRegistration.register(newPrecoProduto);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewPrecoProduto();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	private String getRootErrorMessage(Exception e) {
		// Default to general error message that registration failed.
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			// This shouldn't happen, but return the default messages
			return errorMessage;
		}

		// Start with the exception and recurse to find the root cause
		Throwable t = e;
		while (t != null) {
			// Get the message from the Throwable class instance
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		// This is the root cause message
		return errorMessage;
	}

}
