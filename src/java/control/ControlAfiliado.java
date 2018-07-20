package control;

import entidades.Rol;
import entidades.Usuario;
import facades.AfiliadoFacade;
import facades.EstadoFacade;
import facades.GeneroFacade;
import facades.TipoidentificacionFacade;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import utilitarios.Utilitario;
/**
 *
 * @author CarolVasquez
 */
@ManagedBean(name="afiliado")
@SessionScoped
public class ControlAfiliado {
    
    
    @EJB
    private AfiliadoFacade ejbAfiliado;
    @EJB
    private TipoidentificacionFacade ejbTipoIdentificacion;
    @EJB
    private EstadoFacade ejbEstado;
    @EJB
    private GeneroFacade ejbGenero; 
    
    @Resource
    private UserTransaction transaccion; 
    
    private Utilitario utilitario;
    
    private entidades.Afiliado afiliado;
    private List<entidades.Afiliado> lstAfiliados;

    public ControlAfiliado() {
        
        if (this.utilitario == null){
            
           this.utilitario = new Utilitario();
        }
        
        this.afiliado = new entidades.Afiliado();
        
    }

    public entidades.Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(entidades.Afiliado afiliado) {
        this.afiliado = afiliado;
    }
    

    public AfiliadoFacade getEjbAfiliado() {
        return ejbAfiliado;
    }

    public void setEjbAfiliado(AfiliadoFacade ejbAfiliado) {
        this.ejbAfiliado = ejbAfiliado;
    }

    public TipoidentificacionFacade getEjbTipoIdentificacion() {
        return ejbTipoIdentificacion;
    }

    public void setEjbTipoIdentificacion(TipoidentificacionFacade ejbTipoIdentificacion) {
        this.ejbTipoIdentificacion = ejbTipoIdentificacion;
    }

    public EstadoFacade getEjbEstado() {
        return ejbEstado;
    }

    public void setEjbEstado(EstadoFacade ejbEstado) {
        this.ejbEstado = ejbEstado;
    }

    public GeneroFacade getEjbGenero() {
        return ejbGenero;
    }

    public void setEjbGenero(GeneroFacade ejbGenero) {
        this.ejbGenero = ejbGenero;
    }
    
    // lista los afiliados que estan en la base de datos
    public List<entidades.Afiliado> obtenerAfiliado(){ 
        lstAfiliados = ejbAfiliado.findAll();
        
        return lstAfiliados;
    }
    
    // Registrar ControlAfiliado
    public String registrarAfiliado(){
        try {
            transaccion.begin();
            System.out.println("Ingresa");
                                  
            ejbAfiliado.create(afiliado);
            
            transaccion.commit();
            this.afiliado = new entidades.Afiliado();  //inicializamos de nuevo el objeto para poder registrar de nuevo
            
            this.utilitario.adicionarMensaje("Afiliado Guardado Exitosamente", null, 1);            
            this.afiliado = null;
            this.afiliado = new entidades.Afiliado();
            
        }catch(Exception ex){
            try {
                this.utilitario.adicionarMensaje(ex.getMessage(), null, 2);
                transaccion.rollback();
            }catch(IllegalStateException ex1){
                this.utilitario.adicionarMensaje(ex1.getMessage(), null, 2);
            }catch(SecurityException ex2){
                this.utilitario.adicionarMensaje(ex2.getMessage(), null, 2);
            }catch(SystemException ex3){
                this.utilitario.adicionarMensaje(ex3.getMessage(), null, 2);
            }
                        
        }finally {
            return "afiliados.xhtml"; 
        }
    }
    
    public String editarAfiliado(){
        
        try {
            transaccion.begin();
            

            ejbAfiliado.edit(afiliado);
            
            transaccion.commit();            
            this.utilitario.adicionarMensaje("Afiliado Actualizado Exitosamente", null, 1);            
            this.afiliado = null;
            this.afiliado = new entidades.Afiliado();
            
        }catch(Exception ex){
            try {
                this.utilitario.adicionarMensaje(ex.getMessage(), null, 2);
                transaccion.rollback();
            }catch(IllegalStateException ex1){
                this.utilitario.adicionarMensaje(ex1.getMessage(), null, 2);
            }catch(SecurityException ex2){
                this.utilitario.adicionarMensaje(ex2.getMessage(), null, 2);
            }catch(SystemException ex3){
                this.utilitario.adicionarMensaje(ex3.getMessage(), null, 2);
            }
                        
        }finally {
            return "afiliado.xhtml";
        }        
    }
    
    public void eliminarAfiliado(entidades.Afiliado afiliado){
        
        try{     
            
            transaccion.begin();                            //inicio la transaccion                            
                          
            ejbAfiliado.remove(afiliado);
                        
            transaccion.commit();
            this.utilitario.adicionarMensaje("Afiliado Eliminado Exitosamente", null, 0);
            this.afiliado = null;
            this.afiliado = new entidades.Afiliado();
            
        }catch(Exception ex){
            try{
                this.utilitario.adicionarMensaje(ex.getMessage(), null, 2);
                transaccion.rollback();                                         // utilizamos el rollback por si ocurre una ecepcion desaga lo que no se ha borrado completamente 
            } catch (IllegalStateException ex1) {
                this.utilitario.adicionarMensaje(ex1.getMessage(), null, 2);
            } catch (SecurityException ex2) {
                this.utilitario.adicionarMensaje(ex2.getMessage(), null, 2);
            } catch (SystemException ex3) {
                this.utilitario.adicionarMensaje(ex3.getMessage(), null, 2);
            } 
        }        
        
    } 
}
