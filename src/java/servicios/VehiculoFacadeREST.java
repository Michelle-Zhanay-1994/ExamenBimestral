/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;
import modelo.Vehiculo;

/**
 *
 * @author LENOVO
 */
@Stateless
@Path("modelo.vehiculo")
public class VehiculoFacadeREST extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "LojacarPU")
    private EntityManager em;

    public VehiculoFacadeREST() {
        super(Vehiculo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vehiculo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vehiculo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Vehiculo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("Crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("idvehiculo") int idvehiculo,@FormParam("a\u00f1o")String a\u00f1o,@FormParam("numeropasajeros") String numeropasajeros, @FormParam("modelo")String modelo,@FormParam("maraca")String marca,@FormParam("cilindraje")String cilindraje,@FormParam("paisfabricacion")String paisfabricacion,@FormParam("concesionario")String concesionario){
        Vehiculo ob = new Vehiculo (idvehiculo);
        ob.setAño(año);
        ob.setCilindraje(cilindraje);
        ob.setConcesionario(concesionario);
        ob.setMarca(marca);
        ob.setModelo(modelo);
        ob.setNumeropasajeros(numeropasajeros);
        ob.setPaisfabricacion(paisfabricacion);
        super.create(ob);
        return ("Se creo exitosamente");
    }
    @POST
    @Path("Editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idvehiculo") int idvehiculo,@FormParam("a\u00f1o")String a\u00f1o,@FormParam("numeropasajeros") String numeropasajeros, @FormParam("modelo")String modelo,@FormParam("maraca")String marca,@FormParam("cilindraje")String cilindraje,@FormParam("paisfabricacion")String paisfabricacion,@FormParam("concesionario")String concesionario){
        Vehiculo ob = new Vehiculo (idvehiculo);
        ob.setAño(año);
        ob.setCilindraje(cilindraje);
        ob.setConcesionario(concesionario);
        ob.setMarca(marca);
        ob.setModelo(modelo);
        ob.setNumeropasajeros(numeropasajeros);
        ob.setPaisfabricacion(paisfabricacion);
        if(ob== null){
            return "no se encuentra el id";
        }else{
             super.edit(ob);
            return "Se edito correctamente";
        }
    }
    
     @POST
    @Path("readVehiculo")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public List<Vehiculo> leervehiculo (@FormParam ("numeropasajeros") String numeropasajeros){
        TypedQuery consulta =getEntityManager().createQuery("SELECT v FROM Vehiculo v WHERE v.numeropasajeros = :numeropasajeros",Vehiculo.class);
        consulta.setParameter("numeropasajeros",numeropasajeros);
        return consulta.getResultList();
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
