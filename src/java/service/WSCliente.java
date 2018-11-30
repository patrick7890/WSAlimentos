/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.Cliente;
import dto.facade.ClienteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "WSCliente")
public class WSCliente {

    @EJB
    private ClienteFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createCliente")
    public boolean createCliente(@WebParam(name = "entity") Cliente entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editCliente")
    public boolean editCliente(@WebParam(name = "entity") Cliente entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeCliente")
    public boolean removeCliente(@WebParam(name = "entity") Cliente entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findCliente")
    public Cliente findCliente(@WebParam(name = "id") int id) {
        return ejbRef.findCliente(id);
    }

    @WebMethod(operationName = "findAllCliente")
    public List<Cliente> findAllCliente() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeCliente")
    public List<Cliente> findRangeCliente(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "countCliente")
    public int countCliente() {
        return ejbRef.count();
    }
    
}
