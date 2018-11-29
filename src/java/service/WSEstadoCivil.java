/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.EstadoCivil;
import dto.facade.EstadoCivilFacade;
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
@WebService(serviceName = "WSEstadoCivil")
public class WSEstadoCivil {

    @EJB
    private EstadoCivilFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    public boolean create(@WebParam(name = "entity") EstadoCivil entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    public boolean edit(@WebParam(name = "entity") EstadoCivil entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    public boolean remove(@WebParam(name = "entity") EstadoCivil entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public EstadoCivil findEstadoCivil(@WebParam(name = "id") int id) {
        return ejbRef.findEstadoCivil(id);
    }

    @WebMethod(operationName = "findAll")
    public List<EstadoCivil> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<EstadoCivil> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    
}