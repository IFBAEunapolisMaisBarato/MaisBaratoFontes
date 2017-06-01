package br.edu.ifba.eunapolis.controller;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;

import br.edu.ifba.eunapolis.model.PrecoProduto;

@Model
public class PrecoProdutoController extends Controller {

	@PostConstruct
	public void initNewPrecoProduto() {
		setNewPrecoProduto(new PrecoProduto());
	}
	public void register() throws Exception {
		try {
			getNewPrecoProduto().setUser(getUserRepository().findByFbId(getAuthenticator().getProfile().getValidatedId()));		
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
