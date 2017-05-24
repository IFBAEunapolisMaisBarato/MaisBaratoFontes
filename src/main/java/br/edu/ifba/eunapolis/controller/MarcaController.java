package br.edu.ifba.eunapolis.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.Marca;

@Model
public class MarcaController extends Controller {

	@PostConstruct
	public void initNewMarca() {
		setNewMarca(new Marca());
	}

	public String editar() {

		return "index.js";
	}

	public void register() throws Exception {
		try {
			getMarcaRegistration().register(getNewMarca());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewMarca();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
