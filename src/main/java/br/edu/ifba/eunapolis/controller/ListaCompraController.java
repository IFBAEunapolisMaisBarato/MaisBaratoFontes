package br.edu.ifba.eunapolis.controller;

import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

import br.edu.ifba.eunapolis.model.ListaCompra;
import br.edu.ifba.eunapolis.model.Orcamento;
import br.edu.ifba.eunapolis.model.PrecoProduto;
import br.edu.ifba.eunapolis.model.Produto;

@Model
public class ListaCompraController extends Controller {

	@Inject
	PrecoProdutoController pp;

	public String setSelected(Long id) {
		this.setNewListaCompra(this.findById(id));
		return "add_produtos.jsf";
	}

	public ListaCompra findById(Long id) {
		return this.getListaCompraRepository().findById(id);
	}
	public void setMenorPreco(Long id){
		
		setNewOrcamento(new Orcamento());
		setNewListaCompra(getListaCompraRepository().findById(id));
		getNewOrcamento().setNome(getNewListaCompra().getNome());
		getNewOrcamento().setPrecoProduto(new ArrayList<PrecoProduto>());
		for (Produto listaProduto : getNewListaCompra().getProdutos()) {
			setNewPrecoProduto(getPrecoProdutoRepository().produtoMaisBarato(listaProduto.getId()));
			if (getNewPrecoProduto() != null) {
				getNewOrcamento().getPrecoProduto().add(getNewPrecoProduto());
			}
		}
	}
	public void setMenorPrecoPorPontoVenda(Long id){
		
		setNewOrcamento(new Orcamento());
		setNewListaCompra(getListaCompraRepository().findById(id));
		getNewOrcamento().setNome(getNewListaCompra().getNome());
		getNewOrcamento().setPrecoProduto(new ArrayList<PrecoProduto>());
		for (Produto listaProduto : getNewListaCompra().getProdutos()) {
			setNewPrecoProduto(getPrecoProdutoRepository().produtoMaisBarato(listaProduto.getId()));
			if (getNewPrecoProduto() != null) {
				getNewOrcamento().getPrecoProduto().add(getNewPrecoProduto());
			}
		}
	}
	public String menorPreco(Long id) {
		this.setMenorPreco(id);
		return "melhor_lista.jsf";
	}
	public String menorPrecoPorPontoVenda(Long id) {
		this.setMenorPrecoPorPontoVenda(id);
		return "melhor_lista.jsf";
	}
	
	public void registerOrcameto() throws Exception {
		try {
			this.setMenorPreco(getNewListaCompra().getId());
			ListaCompra oldListaCompra = getListaCompraRepository().findById(getNewListaCompra().getId());		
			getOrcamentoRegistration().register(getNewOrcamento());
			oldListaCompra.getOrcamentos().add(getNewOrcamento());
			getListaCompraRegistration().update(oldListaCompra);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);			
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}

	public void register() throws Exception {
		try {
			setUser(getUserRepository().findByFbId(getAuthenticator().getProfile().getValidatedId()));
			getNewListaCompra().setUser(getUser());
			getListaCompraRegistration().register(getNewListaCompra());
			getUser().getListaCompras().add(getNewListaCompra());
			getUserRegistration().update(getUser());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewListaCompra();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}

	public void addProdutos() throws Exception {
		try {
			ListaCompra oldListaCompra = getListaCompraRepository().findById(getNewListaCompra().getId());
			oldListaCompra.setProdutos(getNewListaCompra().getProdutos());
			getListaCompraRegistration().addProdutos(oldListaCompra);
			setNewListaCompra(oldListaCompra);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
