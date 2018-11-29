/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facade;

import dto.clases.EstadoCivil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class EstadoCivilFacade extends AbstractFacade<EstadoCivil> {

    @PersistenceContext(unitName = "WSAlimentosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCivilFacade() {
        super(EstadoCivil.class);
    }
    public EstadoCivil findEstadoCivil(int id) {
        Query q = em.createNamedQuery("EstadoCivil.findByIdEstadoCivil");
        q.setParameter("idEstadoCivil", id);
        return (EstadoCivil) q.getSingleResult();
    }
}
