package control;

import entidades.Estado;
import entidades.Genero;
import entidades.Tipoidentificacion;
import facades.EstadoFacade;
import facades.GeneroFacade;
import facades.TipoidentificacionFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author CarolVasquez
 */
@ManagedBean(name="parametros")
@SessionScoped
public class Parametros {
    
    @EJB
    private TipoidentificacionFacade ejbTipoIdentificacion;
    
    @EJB
    private GeneroFacade ejbGenero;    
    
    @EJB
    private EstadoFacade ejbEstado; 
    
    private List<Tipoidentificacion> lstTipoIdentificacion;
    
    private List<Genero> lstGenero;
    
    private List<Estado> lstEstado;

    //Constructor
    public Parametros() {
    }

    // encapsulamiento
    public List<Tipoidentificacion> getLstTipoIdentificacion() {
        return lstTipoIdentificacion;
    }

    public void setLstTipoIdentificacion(List<Tipoidentificacion> lstTipoIdentificacion) {
        this.lstTipoIdentificacion = lstTipoIdentificacion;
    }

    
    public List<Tipoidentificacion> obtenerTipoIdentificacion(){
        this.lstTipoIdentificacion = ejbTipoIdentificacion.findAll();
        return this.lstTipoIdentificacion;
    }
    
    public List<Genero> getLstGenero() {
        return lstGenero;
    }

    public void setLstGenero(List<Genero> lstGenero) {
        this.lstGenero = lstGenero;
    }

    
    public List<Genero> obtenerGenero(){
        this.lstGenero = ejbGenero.findAll();
        return this.lstGenero;
    }
    
    public List<Estado> getLstEstado() {
        return lstEstado;
    }

    public void setLstEstado(List<Estado> lstEstado) {
        this.lstEstado = lstEstado;
    }

    
    public List<Estado> obtenerEstado(){
        this.lstEstado = ejbEstado.findAll();
        return this.lstEstado;
    }

}
