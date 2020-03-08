package rest.service;

import core.dao.TransactionDao;
import core.entity.CoTransaction;
import core.service.NumberService;
import jpos.service.JposService;
import org.jboss.weld.context.ejb.Ejb;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationPath("/")
@Path("request")
public class RestService extends Application {
    @EJB
    TransactionDao transactionDao;
    @EJB
    JposService jposService;
    @Inject
    NumberService numberService;

    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id") String id) {
        numberService.Calculator();

        return Response.status(200).entity("getUserById is called, id : " + id)
                .build();
    }
    @POST
    @Path("/movementRequest")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String movementRequest(CoTransaction transaction){
        try {
            transactionDao.create(transaction);
            jposService.clien();
            return "true";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }
    @POST
    @Path("/remainRequest/{requester}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String remainRequest(
            @PathParam("requester") String requester)
         {
        try {
            CoTransaction transaction = new CoTransaction();
            transaction.setSender(requester);
            transactionDao.create(transaction);

            return "true";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }



}
