package br.edu.ifba.eunapolis.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.PontoVenda;

@Model
public class PontoVendaController extends Controller {

	@PostConstruct
	public void initNewPontoVenda() {
		setNewPontoVenda(new PontoVenda());
	}

	public void register() throws Exception {
		try {
			getPontoVendaRegistration().register(getNewPontoVenda());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewPontoVenda();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
