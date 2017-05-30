package br.edu.ifba.eunapolis.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.Produto;

@Model
public class ProdutoController extends Controller {

	@PostConstruct
	public void initNewProduto() {
		setNewProduto(new Produto());
	}

	public void register() throws Exception {
		try {
			getNewProduto().setUser(getUserRepository().findByFbId(getAuthenticator().getProfile().getValidatedId()));
			getProdutoRegistration().register(getNewProduto());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewProduto();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
