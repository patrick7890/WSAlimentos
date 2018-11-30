/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.Detalle;
import dto.facade.DetalleFacade;
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
@WebService(serviceName = "WSDetalle")
public class WSDetalle {

    @EJB
    private DetalleFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createDetalle")
    public boolean createDetalle(@WebParam(name = "entity") Detalle entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editDetalle")
    public boolean editDetalle(@WebParam(name = "entity") Detalle entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeDetalle")
    public boolean removeDetalle(@WebParam(name = "entity") Detalle entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findDetalle")
    public Detalle findDetalle(@WebParam(name = "id") int id) {
        return ejbRef.findDetalle(id);
    }

    @WebMethod(operationName = "findAllDetalle")
    public List<Detalle> findAllDetalle() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeDetalle")
    public List<Detalle> findRangeDetalle(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countDetalle")
    public int countDetalle() {
        return ejbRef.count();
    }
    
}
