/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entidades.Rol;
import entidades.Usuario;
import facades.PermisosFacade;
import facades.RolFacade;
import facades.UsuarioFacade;
import java.io.IOException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.NoResultException;
import javax.transaction.UserTransaction;
import utilitarios.Session;
import utilitarios.Utilitario;

/**
 *
 * @author CarolVasquez
 */
@ManagedBean(name="usuario")
@SessionScoped
public class ControlUsuario {
    
    @EJB
    private UsuarioFacade ejbUsuario;
    @EJB
    private RolFacade ejbRol;
    @EJB
    private PermisosFacade ejbPermisos;
    
    @Resource
    private UserTransaction transaccion; 
    
    private Usuario usuarioSession;
    private entidades.Usuario usuario;
    private Utilitario utilitario;
    private String login;
    private String password;
    private Usuario usuarioExiste;

    public ControlUsuario() {
        
        if (this.utilitario == null){
            
           this.utilitario = new Utilitario();
        }
        
        this.usuario = new entidades.Usuario();
        
    }    
    
    public UsuarioFacade getEjbUsuario() {
        return ejbUsuario;
    }

    public void setEjbUsuario(UsuarioFacade ejbUsuario) {
        this.ejbUsuario = ejbUsuario;
    }

    public RolFacade getEjbRol() {
        return ejbRol;
    }

    public void setEjbRol(RolFacade ejbRol) {
        this.ejbRol = ejbRol;
    }

    public PermisosFacade getEjbPermisos() {
        return ejbPermisos;
    }

    public void setEjbPermisos(PermisosFacade ejbPermisos) {
        this.ejbPermisos = ejbPermisos;
    }

    public UserTransaction getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(UserTransaction transaccion) {
        this.transaccion = transaccion;
    }

    public entidades.Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(entidades.Usuario usuario) {
        this.usuario = usuario;
    }
    
     
    
    public void validarUsuario(String clave) throws IOException{
           
        try{
            boolean loginCorrecto = false;
            this.usuarioSession = ejbUsuario.obtenerUsuarioXloginClaveActivo(this.login.toUpperCase(), clave);            
        
        if (this.usuarioSession != null){
            loginCorrecto = true;
            Session.getInstancia().crearSession_JSF_HTTP(true);             
            Session.getInstancia().getSession().setAttribute("usuarioSession", this.usuarioSession); 
            this.utilitario.adicionarMensaje("CORRECTO!", "BIENVENIDO ", 0);
            /*usuarioSession = null;*/
            Session.getInstancia().redireccionarURL("/faces/afiliados.xhtml");
            
        }else{
                this.utilitario.adicionarMensaje("CONTRASEÑA INCORRECTA", this.login, 2);
            }         
        }catch(NoResultException | NullPointerException ex){
            System.out.println("catch"+ex.getMessage());
        }
        /*usuarioSession = null;*/
        }
    
    public boolean validarExisteUsuario() throws IOException{
    
        this.login = this.usuario.getLogin().toUpperCase();
        this.usuarioExiste = ejbUsuario.obtenerUsuarioXlogin(this.login.toUpperCase());
        
        if(this.usuarioExiste != null){
            validarUsuario(this.usuario.getPassword());
            return true;
        }
        else{
            this.utilitario.adicionarMensaje("USUARIO NO EXISTE", this.login, 2);
            return false;
        }
    
    }
    
    public boolean validarPermisoEditar() throws IOException{
        usuarioSession = (Usuario) Session.getInstancia().getSession().getAttribute("usuarioSession");                  
        Rol rolUsuario = usuarioSession.getFkRolId();
        boolean disableEditar = true;
       Character editar = rolUsuario.getFkPermisosId().getEditar();
       if(editar.equals('T')){disableEditar = true;}else{disableEditar = false;}
                return disableEditar;
        }
    
    public boolean validarPermisoEliminar() throws IOException{
        usuarioSession = (Usuario) Session.getInstancia().getSession().getAttribute("usuarioSession");                  
        Rol rolUsuario = usuarioSession.getFkRolId();
        boolean disableEliminar = true;
        Character eliminar = rolUsuario.getFkPermisosId().getEliminar();
        if(eliminar.equals('T')){disableEliminar = true;}else{disableEliminar = false;}
                return disableEliminar;
        }
    
    public boolean validarPermisoCrear() throws IOException{
        usuarioSession = (Usuario) Session.getInstancia().getSession().getAttribute("usuarioSession");                  
        Rol rolUsuario = usuarioSession.getFkRolId();
        boolean disableCrear = true;
        Character crear = rolUsuario.getFkPermisosId().getCrear();
        if(crear.equals('T')){disableCrear = true;}else{disableCrear = false;}
                return disableCrear;
     }       
}
