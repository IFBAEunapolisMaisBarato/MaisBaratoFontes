package br.edu.ifba.eunapolis.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.UnidadeMedida;

@Model
public class UnidadeMedidaController extends Controller {
	@PostConstruct
	public void initNewUnidadeMedida() {
		setNewUnidadeMedida(new UnidadeMedida());
	}

	public void register() throws Exception {
		try {
			getUnidadeMedidaRegistration().register(getNewUnidadeMedida());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewUnidadeMedida();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
