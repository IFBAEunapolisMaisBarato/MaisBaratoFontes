package br.edu.ifba.eunapolis.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.CategoriaProduto;

@Model
public class CategoriaProdutoController extends Controller {
	
	@PostConstruct
	public void initNewCategoriaProduto() {
		this.setNewCategoriaProduto(new CategoriaProduto());
	}

	public String editTela(Long id) {
		this.setNewCategoriaProduto(this.findById(id));
		return "edit_categoria.jsf";
	}
	public CategoriaProduto findById(Long id) {
		return getCategoriaProdutoRepository().findById(id);
	}

	public void register() throws Exception {
		try {
			getCategoriaProdutoRegistration().register(getNewCategoriaProduto());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			getFacesContext().addMessage(null, m);
			initNewCategoriaProduto();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}

	public void update() throws Exception {
		try {
			getCategoriaProdutoRegistration().update(getNewCategoriaProduto());
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado Com Sucesso!",
					"Registration successful");
			getFacesContext().addMessage(null, m);
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}

	public void delete(Long id) throws Exception {
		try {
			getCategoriaProdutoRegistration().delete(this.findById(id));
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado", "Deletation successful");
			getFacesContext().addMessage(null, m);
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Deletation unsuccessful");
			getFacesContext().addMessage(null, m);
		}
	}
}
