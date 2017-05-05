package br.edu.ifba.eunapolis.controller.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifba.eunapolis.data.CategoriaProdutoRepository;
import br.edu.ifba.eunapolis.model.CategoriaProduto;

@FacesConverter(forClass=CategoriaProduto.class, value = "categoriaProdutoConverter")
public class CategoriaProdutoConverter implements Converter {
	
	
	@Inject
	private CategoriaProdutoRepository categoriaProdutoRepository;
	
	 public Object getAsObject(FacesContext ctx, UIComponent component, String string) {
	        if (string == null) {
	           
	            return null;
	        }
	        CategoriaProduto categoriaProduto = null;
	        
	        if ((string != null) && (!string.equals(""))) {
	        	categoriaProduto = categoriaProdutoRepository.findById(Long.valueOf(string));
	        }
	        return categoriaProduto;
	    }

	    public String getAsString(FacesContext context, UIComponent component,
			Object value) {
	    	 if ((value != null) && (!value.equals(""))) {
	        	CategoriaProduto categoriaProduto = (CategoriaProduto) value;
	            return String.valueOf(categoriaProduto.getId());
	        }
	        return null;
	    }

}
