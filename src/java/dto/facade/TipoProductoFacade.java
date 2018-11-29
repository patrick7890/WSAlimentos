/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.facade;

import dto.clases.TipoProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Patricio
 */
@Stateless
public class TipoProductoFacade extends AbstractFacade<TipoProducto> {

    @PersistenceContext(unitName = "WSAlimentosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProductoFacade() {
        super(TipoProducto.class);
    }

    public TipoProducto findTipoProducto(int id) {
        Query q = em.createNamedQuery("TipoProducto.findByIdTp");
        q.setParameter("idTp", id);
        return (TipoProducto) q.getSingleResult();
    }
}
