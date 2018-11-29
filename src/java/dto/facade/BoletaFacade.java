/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facade;

import dto.clases.Boleta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class BoletaFacade extends AbstractFacade<Boleta> {

    @PersistenceContext(unitName = "WSAlimentosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoletaFacade() {
        super(Boleta.class);
    }
    public Boleta findBoleta(int id) {
        Query q = em.createNamedQuery("Boleta.findByIdBoleta");
        q.setParameter("idBoleta", id);
        return (Boleta) q.getSingleResult();
    }
    
}
