/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.Boleta;
import dto.facade.BoletaFacade;
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
@WebService(serviceName = "WSBoleta")
public class WSBoleta {

    @EJB
    private BoletaFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    public boolean create(@WebParam(name = "entity") Boleta entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    public boolean edit(@WebParam(name = "entity") Boleta entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    public boolean remove(@WebParam(name = "entity") Boleta entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Boleta findBoleta(@WebParam(name = "id") int id) {
        return ejbRef.findBoleta(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Boleta> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Boleta> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    
}