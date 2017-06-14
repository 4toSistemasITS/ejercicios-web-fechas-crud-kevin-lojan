/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Area;
import com.model.Estudiante;
import static com.model.Estudiante_.idestudiante;
import com.model.Materia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

/**
 *
 * @author Kevin
 */
@Stateless
@Path("com.model.estudiante")
public class EstudianteFacadeREST extends AbstractFacade<Estudiante> {

    @PersistenceContext(unitName = "trabajoweb-institucionPU")
    private EntityManager em;
    
    @EJB
    MateriaFacadeREST materiaFacadeREST;

    public EstudianteFacadeREST() {
        super(Estudiante.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Estudiante entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Estudiante entity) {
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
    public Estudiante find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear1(@FormParam("nombre") String nombre,@FormParam("cedula") String cedula, @FormParam("idarea") int idmateria) {
  
    String mensaje="{\"exitoso\":false}";
    Materia ob1 = materiaFacadeREST.find(idmateria);
      try {
           create (new Estudiante(nombre,cedula,ob1));
           mensaje="{\"exitoso\":bien}";
       } catch (Exception e) {
           System.out.println(e);
       }
    return mensaje;
    }
    
    
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("idestudiante") int idestudiante,@FormParam("nombre") String nombre,@FormParam("cedula") String cedula,@FormParam("idmateria") int idmateria) {
            String mensaje="{\"exitoso\":false,\":motivo\"}";
            Estudiante a= BUSCAR(idestudiante);
            Materia ob = materiaFacadeREST.find(idmateria);

            if(a != null){  
                a.setNombre(nombre);
                a.setIdmateria(ob);
                a.setCedula(cedula);
                
                try {
                edit( a);
                 mensaje="{\"exitoso\":true}";
                 } catch (Exception e) {
                      mensaje="\"Exception en base\"";
                 }

            }else{
                       mensaje="\"Datos no incorrectos\"";
  
            }
         
            return mensaje;
    
    }
    public Estudiante BUSCAR(int idestudiante){
        
        TypedQuery<Estudiante>qry;
        qry=getEntityManager().createQuery("SELECT u FROM Estudiante u WHERE u.idestudiante = :idestudiante ", Estudiante.class);
        qry.setParameter("idestudiante", idestudiante);
        

        try {
            return qry.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }   
    }
//    @POST
//    @Path("eliminar")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
//    public String eliminar(@FormParam("idestudiante") int idestudiante,@FormParam("nombre") String nombre,@FormParam("cedula") String cedula,@FormParam("idmateria") int idmateria,@FormParam("cedula") String cedula,@FormParam("eliminado") boolean eliminado) {
//        String mensaje = "{\"exitoso\":false,\"motivo\":";
//        Estudiante a= buscar_id(idestudiante);
//        a.set(null);
//        if (v != null) {
//            try {
//                edit(v);
//                mensaje = "{\"exitoso\":true";
//            } catch (Exception e) {
//                mensaje += "\"Excepcion en base\"";
//            }
//        } else {
//            mensaje += "\"Datos no correctos\"";
//        }
//        mensaje += "}";
//        return mensaje;
//
//    }
//
//    public Vehiculo buscar_id(int idvehiculo) {
//        Vehiculo v = null;
//        TypedQuery<Vehiculo> qry;
//        qry = getEntityManager().createQuery("SELECT v FROM Vehiculo v WHERE v.idvehiculo = :idvehiculo and v.eliminado = :eliminado", Vehiculo.class);
//        qry.setParameter("idvehiculo", idvehiculo);
//        qry.setParameter("eliminado", 0);
//        try {
//            return qry.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//
//    }

}
