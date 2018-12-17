/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.Producto;
import dto.facade.ProductoFacade;
import dto.facade.SubtipoProductoFacade;
import java.util.Date;
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
    private ProductoFacade productoFacade;

    @EJB
    private SubtipoProductoFacade subtipoProductoFacade;

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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CreateProducto2")
    public boolean CreateProducto2(@WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "anioF") Date anioF, @WebParam(name = "anioV") Date anioV, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "stock") int stock, @WebParam(name = "tarifa") double tarifa, @WebParam(name = "idSubTipo") int idSubTipo) {
        
        
        Producto p = new Producto(null, nombre, precio);
        p.setAnioF(anioF);
        p.setAnioV(anioV);
        p.setDescripcionProducto(descripcion);
        p.setTarificacion(tarifa);
        p.setStock(stock);
        p.setSubtipoProducto(subtipoProductoFacade.findSubtipo(idSubTipo));
        
        
        return ejbRef.create(p);
        
        
    }

}
