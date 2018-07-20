/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CarolVasquez
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "AfiliacionUsuariosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario obtenerUsuarioXlogin(String login){  
            
        Query consulta = em.createNamedQuery("Usuario.findByLogin");   
        consulta.setParameter("login", login);                         
        
        try {
            Usuario oUsuario = (Usuario) consulta.getSingleResult();
            em.refresh(oUsuario);
            if(oUsuario != null) {
                    return oUsuario;
                }else {
                    return null;
                }
        }catch(NoResultException e) {
            return null;
        }
    
    }
        
    public Usuario obtenerUsuarioXloginClaveActivo(String login, String clave){  
            
        Query consulta = em.createNamedQuery("Usuario.findByLogin");   
        consulta.setParameter("login", login);                         
        
        try {
            Usuario oUsuario = (Usuario) consulta.getSingleResult();
            em.refresh(oUsuario);
            if(oUsuario != null) {
                System.out.println("Variables: "+oUsuario.getPassword()+clave);
                if(oUsuario.getPassword().equals(clave)){
                    return oUsuario;
                    }else{
                        return null;
                         }
                
            } else {
                return null;
            }            
        }catch(NoResultException e) {
            return null;
        }    
    }
   
}
