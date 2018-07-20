package utilitarios;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import entidades.Usuario;


public class Session {
    
    private static Session INSTANCIA;   // instancia para patron singleton
    
    private HttpServletRequest request;
    private HttpSession session;


    private FacesContext facesContext;
    private ExternalContext externalContext;
    
    private Session(){    // constructro provado para patron singleton
    
    } 
    
    public static Session getInstancia(){  // llamamaos el objeto session a traves de este metodo 
        if (INSTANCIA == null) {                // solo se crea una instancia por cada session
            INSTANCIA = new Session();
        }        
        return INSTANCIA;
    }
    
    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
    
    public void crearSession_JSF_HTTP(boolean crearSession) {           // crear la session de usuario
        this.request = (HttpServletRequest)FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        this.session = this.request.getSession();
        this.session.invalidate();
        this.session = this.request.getSession(crearSession);
        
        if(crearSession == false) {
            INSTANCIA = null;
        }
        
    }
    
    public void redireccionarURL(String url) {                              // metodo para re direccionar la url para navegar por las paginas
        this.facesContext = FacesContext.getCurrentInstance();
        this.externalContext = this.facesContext.getExternalContext();
        String urlBase = this.externalContext.getRequestContextPath();
        
        try {
            this.externalContext.redirect(urlBase + url);
        } catch (IOException e) {
            System.out.println("Error en direccionamiento URL: " + e.getMessage());  
        }
        this.facesContext.renderResponse();
    }
    
    public Usuario obtenerUsuarioLogueado() {                                  // este metodo me obtiene el usuario que esta logueado
       
        Usuario usuario = (Usuario)this.session.getAttribute("usuarioSession");        
        return usuario;
        
    }
    
    
    
    
}
