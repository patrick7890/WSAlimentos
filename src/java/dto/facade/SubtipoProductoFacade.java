/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facade;

import dto.clases.SubtipoProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class SubtipoProductoFacade extends AbstractFacade<SubtipoProducto> {

    @PersistenceContext(unitName = "WSAlimentosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubtipoProductoFacade() {
        super(SubtipoProducto.class);
    }
    public SubtipoProducto findSubtipo(int id) {
        Query q = em.createNamedQuery("SubtipoProducto.findBySubtipoP");
        q.setParameter("subtipoP", id);
        return (SubtipoProducto) q.getSingleResult();
    }
}
