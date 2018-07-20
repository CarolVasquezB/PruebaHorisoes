/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.Afiliado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CarolVasquez
 */
@Stateless
public class AfiliadoFacade extends AbstractFacade<Afiliado> {

    @PersistenceContext(unitName = "AfiliacionUsuariosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AfiliadoFacade() {
        super(Afiliado.class);
    }
    
}
