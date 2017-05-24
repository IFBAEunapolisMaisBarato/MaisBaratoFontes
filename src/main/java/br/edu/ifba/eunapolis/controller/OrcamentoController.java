package br.edu.ifba.eunapolis.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.Orcamento;

@Model
public class OrcamentoController extends Controller {

	@PostConstruct
	public void initNewOrcamento() {
		setNewOrcamento(new Orcamento());
	}

	public void register() throws Exception {
		try {
			setNewOrcamento(new Orcamento());
			getNewOrcamento().setNome(getNewListaCompra().getNome());
			getNewOrcamento().setPrecoProduto(getListaPrecoProduto());
			getOrcamentoRegistration().register(getNewOrcamento());
			getNewListaCompra().getOrcamentos().add(getNewOrcamento());
			getListaCompraRegistration().update(getNewListaCompra());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewOrcamento();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
