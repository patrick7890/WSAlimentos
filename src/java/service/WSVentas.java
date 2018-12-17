/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.clases.Ventas;
import dto.facade.ClienteFacade;
import dto.facade.VentasFacade;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Patricio
 */
@WebService(serviceName = "WSVentas")
public class WSVentas {

    @EJB
    private ClienteFacade clienteFacade;

    
    @EJB
    private VentasFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "createVentas")
    public boolean createVentas(@WebParam(name = "entity") Ventas entity) {
        return ejbRef.create(entity);
    }

    @WebMethod(operationName = "editVentas")
    public boolean editVentas(@WebParam(name = "entity") Ventas entity) {
        return ejbRef.edit(entity);
    }

    @WebMethod(operationName = "removeVentas")
    public boolean removeVentas(@WebParam(name = "entity") Ventas entity) {
        return ejbRef.remove(entity);
    }

    @WebMethod(operationName = "findVentas")
    public Ventas findVentas(@WebParam(name = "id") int id) {
        return ejbRef.findVentas(id);
    }

    @WebMethod(operationName = "findAllVentas")
    public List<Ventas> findAllVentas() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRangeVentas")
    public List<Ventas> findRangeVentas(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int countVentas() {
        return ejbRef.count();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CrearVenta2")
    public boolean CrearVenta2(@WebParam(name = "activo") boolean activo, @WebParam(name = "fechaE") Date fechaE, @WebParam(name = "dv") String dv,
           @WebParam(name = "rut") int rut ) {
        
        Ventas v = new Ventas();
        v.setActivoV(activo);
        v.setFechaEntrega(fechaE);
        v.setFechaVenta(new Date());
        v.setClienteIdCliente(clienteFacade.findCliente(rut, dv));
        
        return ejbRef.create(v);
    }

    /**
     * Web service operation
     */
    
}
