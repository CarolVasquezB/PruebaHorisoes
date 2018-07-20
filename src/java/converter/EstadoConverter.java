/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import control.Parametros;
import entidades.Estado;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author CarolVasquez
 */
@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0 && !value.toUpperCase().contains("SELECCIONE")){
            try {
                Parametros paramController = (Parametros) context.getExternalContext().getSessionMap().get("parametros");
                if(paramController != null && paramController.getLstEstado()!= null){
                    int indice = 0;
                    Iterator<Estado> itEstado = paramController.getLstEstado().iterator();
                    while (itEstado.hasNext()){
                        Estado oEstado = itEstado.next();
                        if(oEstado.getDescripcion().equals(value)) {
                            indice = paramController.getLstEstado().indexOf(oEstado);
                            break;
                        }
                    }
                    return paramController.getLstEstado().get(indice);
                    
                }else {
                    return null;
                }
            } catch(NumberFormatException e){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error !", "No es valido el Estado"));
            }
            
        }else{
            return null;
        }        
    }   
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       return null;
    }
}
