/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.TipoProducto;
import dto.facade.TipoProductoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "WSTipo")
public class WSTipo {

    @EJB
    private TipoProductoFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createTipo")
    public boolean createTipo(@WebParam(name = "entity") TipoProducto entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editTipo")
    public boolean editTipo(@WebParam(name = "entity") TipoProducto entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeTipo")
    public boolean removeTipo(@WebParam(name = "entity") TipoProducto entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findTipo")
    public TipoProducto findTipo(@WebParam(name = "id") int id) {
        return ejbRef.findTipoProducto(id);
    }

    @WebMethod(operationName = "findAllTipo")
    public List<TipoProducto> findAllTipo() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeTipo")
    public List<TipoProducto> findRangeTipo(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countTipo")
    public int countTipo() {
        return ejbRef.count();
    }

    
}
