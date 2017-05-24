package br.edu.ifba.eunapolis.controller;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import br.edu.ifba.eunapolis.model.ListaCompra;

@Model
public class ListaCompraController extends Controller {

	public String setSelected(Long id) {
		this.setNewListaCompra(this.findById(id));
		return "add_produtos.jsf";
	}

	public ListaCompra findById(Long id) {
		return this.getListaCompraRepository().findById(id);
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
