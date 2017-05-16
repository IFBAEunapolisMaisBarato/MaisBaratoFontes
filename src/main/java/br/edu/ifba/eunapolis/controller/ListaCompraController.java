/**
 * 
 */
package br.edu.ifba.eunapolis.controller;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import br.edu.ifba.eunapolis.data.ListaCompraRepository;
import br.edu.ifba.eunapolis.model.ListaCompra;
import br.edu.ifba.eunapolis.service.ListaCompraRegistration;

/**
 * @author Jonathas John
 * @version 1.0.0
 * @since 05/05/2017
 *
 */

@Model
public class ListaCompraController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private ListaCompraRegistration listaCompraRegistration;

	@Inject
	private ListaCompraRepository listaCompraRepository;

	@Produces
	@Named
	private ListaCompra newListaCompra;

	@PostConstruct
	public void initNewListaCompra() {
		newListaCompra = new ListaCompra();
	}

	public String setSelected(Long id) {
		this.newListaCompra = this.findById(id);
		return "add_produtos.jsf";
	}

	public ListaCompra findById(Long id) {
		return listaCompraRepository.findById(id);
	}

	public void register() throws Exception {
		try {
			listaCompraRegistration.register(newListaCompra);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			initNewListaCompra();
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	public void addProdutos() throws Exception {
		try {
			ListaCompra oldListaCompra = listaCompraRepository.findById(newListaCompra.getId());
			oldListaCompra.setProdutos(newListaCompra.getProdutos());
			listaCompraRegistration.addProdutos(oldListaCompra);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
		} catch (Exception e) {
			String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	private String getRootErrorMessage(Exception e) {
		// Default to general error message that registration failed.
		String errorMessage = "Registration failed. See server log for more information";
		if (e == null) {
			// This shouldn't happen, but return the default messages
			return errorMessage;
		}

		// Start with the exception and recurse to find the root cause
		Throwable t = e;
		while (t != null) {
			// Get the message from the Throwable class instance
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		// This is the root cause message
		return errorMessage;
	}
}
