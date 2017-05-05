package br.edu.ifba.eunapolis.controller.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.edu.ifba.eunapolis.model.AbstractEntity;

@Named
public class EntityConverter implements Converter {
	
	@Inject
    private Logger log;

	@Inject
	private EntityManager em;

	public Object getAsObject(FacesContext ctx, UIComponent component, String string) {

		AbstractEntity entity = null;
		try {
			if ((string != null) && (!string.equals(""))) {
				if (string.contains("#")){
					String[] values = string.split("#");
					if(values.length == 2){
						entity = (AbstractEntity) em.find(Class.forName(values[0]), Long.valueOf(values[1]));
					}
				}
			}
//		} catch (NumberFormatException ce) {
//			log.log(Level.SEVERE, ce.getMessage(), ce);
//			FacesMessage errMsg = new FacesMessage("ConversionError");
//	        FacesContext.getCurrentInstance().addMessage(null, errMsg);
//	        throw new ConverterException(errMsg.getSummary());
//		} catch (ClassCastException ce) {
//			log.log(Level.SEVERE, ce.getMessage(), ce);
//			FacesMessage errMsg = new FacesMessage("ConversionError");
//	        FacesContext.getCurrentInstance().addMessage(null, errMsg);
//	        throw new ConverterException(errMsg.getSummary());
//		} catch (ClassNotFoundException e) {
//			log.log(Level.SEVERE, e.getMessage(), e);
//			FacesMessage errMsg = new FacesMessage("ConversionError");
//	        FacesContext.getCurrentInstance().addMessage(null, errMsg);
//	        throw new ConverterException(errMsg.getSummary());
	    
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
			FacesMessage errMsg = new FacesMessage("ConversionError");
	        FacesContext.getCurrentInstance().addMessage(null, errMsg);
	        throw new ConverterException(errMsg.getSummary());
		}

		return entity;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if ((value != null) && (!value.equals(""))) {
			AbstractEntity entity = (AbstractEntity)value;
			return entity.getClass().getName()+"#"+entity.getId();
		}
		return null;
	}

}
