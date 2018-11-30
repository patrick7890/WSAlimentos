/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.Producto;
import dto.facade.ProductoFacade;
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
@WebService(serviceName = "WSProducto")
public class WSProducto {

    @EJB
    private ProductoFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createProducto")
    public boolean createProducto(@WebParam(name = "entity") Producto entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editProducto")
    public boolean editProducto(@WebParam(name = "entity") Producto entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeProducto")
    public boolean removeProducto(@WebParam(name = "entity") Producto entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findProducto")
    public Producto findProducto(@WebParam(name = "id") int id) {
        return ejbRef.findProducto(id);
    }

    @WebMethod(operationName = "findAllProducto")
    public List<Producto> findAllProducto() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeProducto")
    public List<Producto> findRangeProducto(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countProducto")
    public int countProducto() {
        return ejbRef.count();
    }

}
