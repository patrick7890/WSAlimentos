/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facade;

import dto.clases.Detalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class DetalleFacade extends AbstractFacade<Detalle> {

    @PersistenceContext(unitName = "WSAlimentosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFacade() {
        super(Detalle.class);
    }
    public Detalle findDetalle(int id) {
        Query q = em.createNamedQuery("Detalle.findByIdDetalle");
        q.setParameter("idDetalle", id);
        return (Detalle) q.getSingleResult();
    }
}
