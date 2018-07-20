/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CarolVasquez
 */
@Entity
@Table(name = "afiliado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Afiliado.findAll", query = "SELECT a FROM Afiliado a")
    , @NamedQuery(name = "Afiliado.findByAfiliadoId", query = "SELECT a FROM Afiliado a WHERE a.afiliadoId = :afiliadoId")
    , @NamedQuery(name = "Afiliado.findByIdentificacion", query = "SELECT a FROM Afiliado a WHERE a.identificacion = :identificacion")
    , @NamedQuery(name = "Afiliado.findByNombre1", query = "SELECT a FROM Afiliado a WHERE a.nombre1 = :nombre1")
    , @NamedQuery(name = "Afiliado.findByNombre2", query = "SELECT a FROM Afiliado a WHERE a.nombre2 = :nombre2")
    , @NamedQuery(name = "Afiliado.findByApellido1", query = "SELECT a FROM Afiliado a WHERE a.apellido1 = :apellido1")
    , @NamedQuery(name = "Afiliado.findByApellido2", query = "SELECT a FROM Afiliado a WHERE a.apellido2 = :apellido2")
    , @NamedQuery(name = "Afiliado.findByDireccion", query = "SELECT a FROM Afiliado a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Afiliado.findByTelefono", query = "SELECT a FROM Afiliado a WHERE a.telefono = :telefono")})
public class Afiliado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="SQ_Afiliado", sequenceName="SQ_Afiliado", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_Afiliado")
    @Basic(optional = false)
    @NotNull
    @Column(name = "afiliado_id")
    private Integer afiliadoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre1")
    private String nombre1;
    @Size(max = 25)
    @Column(name = "nombre2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "fk_estado_id", referencedColumnName = "estado_id")
    @ManyToOne
    private Estado fkEstadoId;
    @JoinColumn(name = "fk_genero_id", referencedColumnName = "genero_id")
    @ManyToOne
    private Genero fkGeneroId;
    @JoinColumn(name = "fk_tipoidentificacion_id", referencedColumnName = "tipoidentificacion_id")
    @ManyToOne
    private Tipoidentificacion fkTipoidentificacionId;

    public Afiliado() {
    }

    public Afiliado(Integer afiliadoId) {
        this.afiliadoId = afiliadoId;
    }

    public Afiliado(Integer afiliadoId, String identificacion, String nombre1, String apellido1) {
        this.afiliadoId = afiliadoId;
        this.identificacion = identificacion;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
    }

    public Integer getAfiliadoId() {
        return afiliadoId;
    }

    public void setAfiliadoId(Integer afiliadoId) {
        this.afiliadoId = afiliadoId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Estado getFkEstadoId() {
        return fkEstadoId;
    }

    public void setFkEstadoId(Estado fkEstadoId) {
        this.fkEstadoId = fkEstadoId;
    }

    public Genero getFkGeneroId() {
        return fkGeneroId;
    }

    public void setFkGeneroId(Genero fkGeneroId) {
        this.fkGeneroId = fkGeneroId;
    }

    public Tipoidentificacion getFkTipoidentificacionId() {
        return fkTipoidentificacionId;
    }

    public void setFkTipoidentificacionId(Tipoidentificacion fkTipoidentificacionId) {
        this.fkTipoidentificacionId = fkTipoidentificacionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afiliadoId != null ? afiliadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Afiliado)) {
            return false;
        }
        Afiliado other = (Afiliado) object;
        if ((this.afiliadoId == null && other.afiliadoId != null) || (this.afiliadoId != null && !this.afiliadoId.equals(other.afiliadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Afiliado[ afiliadoId=" + afiliadoId + " ]";
    }
    
}
