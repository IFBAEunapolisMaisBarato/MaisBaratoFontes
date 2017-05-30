package br.edu.ifba.eunapolis.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;

import br.edu.ifba.eunapolis.model.Similar;
import br.edu.ifba.eunapolis.model.User;

@Model
public class SimilarController extends Controller {

	@PostConstruct
	public void initNewSimilar() {
		setNewSimilar(new Similar());
	}

	public void register() throws Exception {
		try {
			User user = getUserRepository().findByFbId(getAuthenticator().getProfile().getValidatedId());
			getNewSimilar().setUser(user);
			getSimilarRegistration().register(getNewSimilar());
			user.getSimilar().add(getNewSimilar());
			getUserRegistration().update(user);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewSimilar();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
	public void update() throws Exception {
		try {
			getSimilarRegistration().update(getNewSimilar());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado Com Sucesso!",
					"Registration successful");
			getFacesContext().addMessage(null, m);
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
