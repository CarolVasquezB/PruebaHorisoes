/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CarolVasquez
 */
@Entity
@Table(name = "tipoidentificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoidentificacion.findAll", query = "SELECT t FROM Tipoidentificacion t")
    , @NamedQuery(name = "Tipoidentificacion.findByTipoidentificacionId", query = "SELECT t FROM Tipoidentificacion t WHERE t.tipoidentificacionId = :tipoidentificacionId")
    , @NamedQuery(name = "Tipoidentificacion.findByCodigo", query = "SELECT t FROM Tipoidentificacion t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipoidentificacion.findByDescripcion", query = "SELECT t FROM Tipoidentificacion t WHERE t.descripcion = :descripcion")})
public class Tipoidentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoidentificacion_id")
    private Integer tipoidentificacionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "fkTipoidentificacionId")
    private List<Afiliado> afiliadoList;

    public Tipoidentificacion() {
    }

    public Tipoidentificacion(Integer tipoidentificacionId) {
        this.tipoidentificacionId = tipoidentificacionId;
    }

    public Tipoidentificacion(Integer tipoidentificacionId, String codigo, String descripcion) {
        this.tipoidentificacionId = tipoidentificacionId;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getTipoidentificacionId() {
        return tipoidentificacionId;
    }

    public void setTipoidentificacionId(Integer tipoidentificacionId) {
        this.tipoidentificacionId = tipoidentificacionId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Afiliado> getAfiliadoList() {
        return afiliadoList;
    }

    public void setAfiliadoList(List<Afiliado> afiliadoList) {
        this.afiliadoList = afiliadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoidentificacionId != null ? tipoidentificacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoidentificacion)) {
            return false;
        }
        Tipoidentificacion other = (Tipoidentificacion) object;
        if ((this.tipoidentificacionId == null && other.tipoidentificacionId != null) || (this.tipoidentificacionId != null && !this.tipoidentificacionId.equals(other.tipoidentificacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipoidentificacion[ tipoidentificacionId=" + tipoidentificacionId + " ]";
    }
    
}
