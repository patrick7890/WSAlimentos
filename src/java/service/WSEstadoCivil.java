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

    @WebMethod(operationName = "createEstadoCivil")
    public boolean createEstadoCivil(@WebParam(name = "entity") EstadoCivil entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editEstadoCivil")
    public boolean editEstadoCivil(@WebParam(name = "entity") EstadoCivil entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeEstadoCivil")
    public boolean removeEstadoCivil(@WebParam(name = "entity") EstadoCivil entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findEstadoCivil")
    public EstadoCivil findEstadoCivil(@WebParam(name = "id") int id) {
        return ejbRef.findEstadoCivil(id);
    }

    @WebMethod(operationName = "findAllEstadoCivil")
    public List<EstadoCivil> findAllEstadoCivil() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeEstadoCivil")
    public List<EstadoCivil> findRangeEstadoCivil(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countEstadoCivil")
    public int countEstadoCivil() {
        return ejbRef.count();
    }

    
}
