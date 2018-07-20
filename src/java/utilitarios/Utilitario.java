/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author CarolVasquez
 */
public class Utilitario {
     public void adicionarMensaje(String msjEncabezado, String msjDetalle, int tipoMensaje){
        
        FacesMessage msj = null;
        
        switch(tipoMensaje){
            case 0:
                msj = new FacesMessage(FacesMessage.SEVERITY_INFO, msjEncabezado, msjDetalle);
                break;
            case 1:
                msj = new FacesMessage(FacesMessage.SEVERITY_WARN, msjEncabezado, msjDetalle);
                break;
            case 2:
                msj = new FacesMessage(FacesMessage.SEVERITY_ERROR, msjEncabezado, msjDetalle);
                break;
            case 3:
                msj = new FacesMessage(FacesMessage.SEVERITY_FATAL, msjEncabezado, msjDetalle);
                break;
        }
        
        FacesContext.getCurrentInstance().addMessage(null, msj);
    }
}
