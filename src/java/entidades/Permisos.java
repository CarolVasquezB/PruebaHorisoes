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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CarolVasquez
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p")
    , @NamedQuery(name = "Permisos.findByPermisosId", query = "SELECT p FROM Permisos p WHERE p.permisosId = :permisosId")
    , @NamedQuery(name = "Permisos.findByCrear", query = "SELECT p FROM Permisos p WHERE p.crear = :crear")
    , @NamedQuery(name = "Permisos.findByEditar", query = "SELECT p FROM Permisos p WHERE p.editar = :editar")
    , @NamedQuery(name = "Permisos.findByEliminar", query = "SELECT p FROM Permisos p WHERE p.eliminar = :eliminar")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "permisos_id")
    private Integer permisosId;
    @Column(name = "crear")
    private Character crear;
    @Column(name = "editar")
    private Character editar;
    @Column(name = "eliminar")
    private Character eliminar;
    @OneToMany(mappedBy = "fkPermisosId")
    private List<Rol> rolList;

    public Permisos() {
    }

    public Permisos(Integer permisosId) {
        this.permisosId = permisosId;
    }

    public Integer getPermisosId() {
        return permisosId;
    }

    public void setPermisosId(Integer permisosId) {
        this.permisosId = permisosId;
    }

    public Character getCrear() {
        return crear;
    }

    public void setCrear(Character crear) {
        this.crear = crear;
    }

    public Character getEditar() {
        return editar;
    }

    public void setEditar(Character editar) {
        this.editar = editar;
    }

    public Character getEliminar() {
        return eliminar;
    }

    public void setEliminar(Character eliminar) {
        this.eliminar = eliminar;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisosId != null ? permisosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.permisosId == null && other.permisosId != null) || (this.permisosId != null && !this.permisosId.equals(other.permisosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Permisos[ permisosId=" + permisosId + " ]";
    }
    
}
