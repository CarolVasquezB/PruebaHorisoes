/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import control.Parametros;
import entidades.Genero;
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
@FacesConverter("generoConverter")
public class GeneroConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0 && !value.toUpperCase().contains("SELECCIONE")){
            try {
                Parametros paramController = (Parametros) context.getExternalContext().getSessionMap().get("parametros");
                if(paramController != null && paramController.getLstGenero()!= null){
                    int indice = 0;
                    Iterator<Genero> itGenero = paramController.getLstGenero().iterator();
                    while (itGenero.hasNext()){
                        Genero oGenero = itGenero.next();
                        if(oGenero.getDescripcion().equals(value)) {
                            indice = paramController.getLstGenero().indexOf(oGenero);
                            break;
                        }
                    }
                    return paramController.getLstGenero().get(indice);
                    
                }else {
                    return null;
                }
            } catch(NumberFormatException e){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error !", "No es valido el Género"));
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
