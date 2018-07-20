/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.Tipoidentificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CarolVasquez
 */
@Stateless
public class TipoidentificacionFacade extends AbstractFacade<Tipoidentificacion> {

    @PersistenceContext(unitName = "AfiliacionUsuariosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoidentificacionFacade() {
        super(Tipoidentificacion.class);
    }
    
}
