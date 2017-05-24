package br.edu.ifba.eunapolis.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.Rede;

/**
 * @author Michael Rocha
 * @version 1.0.0
 * @since 04/05/2017
 *
 */

@Model
public class RedeController extends Controller{

	@PostConstruct
	public void initNewRede() {
		setNewRede(new Rede());
	}

	public void register() throws Exception {
		try {
			getRedeRegistration().register(getNewRede());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewRede();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}