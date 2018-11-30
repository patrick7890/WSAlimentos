/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.SubtipoProducto;
import dto.facade.SubtipoProductoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "WSSubTipo")
public class WSSubTipo {

    @EJB
    private SubtipoProductoFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createSubTipo")
    public boolean createSubTipo(@WebParam(name = "entity") SubtipoProducto entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "edioSubTipo")
    public boolean edioSubTipo(@WebParam(name = "entity") SubtipoProducto entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removoSubTipo")
    public boolean removoSubTipo(@WebParam(name = "entity") SubtipoProducto entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findSubtipoProducto")
    public SubtipoProducto findSubtipoProducto(@WebParam(name = "id") int id) {
        return ejbRef.findSubtipo(id);
    }

    @WebMethod(operationName = "findAllSubTipo")
    public List<SubtipoProducto> findAllSubTipo() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeSubTipo")
    public List<SubtipoProducto> findRangeSubTipo(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countSubTipo")
    public int countSubTipo() {
        return ejbRef.count();
    }

    
}
