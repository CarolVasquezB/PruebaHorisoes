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
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g")
    , @NamedQuery(name = "Genero.findByGeneroId", query = "SELECT g FROM Genero g WHERE g.generoId = :generoId")
    , @NamedQuery(name = "Genero.findByDescripcion", query = "SELECT g FROM Genero g WHERE g.descripcion = :descripcion")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero_id")
    private Integer generoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "fkGeneroId")
    private List<Afiliado> afiliadoList;

    public Genero() {
    }

    public Genero(Integer generoId) {
        this.generoId = generoId;
    }

    public Genero(Integer generoId, String descripcion) {
        this.generoId = generoId;
        this.descripcion = descripcion;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
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
        hash += (generoId != null ? generoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.generoId == null && other.generoId != null) || (this.generoId != null && !this.generoId.equals(other.generoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Genero[ generoId=" + generoId + " ]";
    }
    
}
