package rws;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import sessionbean.QueryBean;

@Path("queryehr")
public class QueryRWS {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;
    @EJB 
    QueryBean querybean;
    /**
     * Default con structor. 
     */
    public QueryRWS() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of QueryRWS
     * @return an instance of String
     */
    @GET
    @Produces("text/html")
    public String getHtml(@PathParam("sql") String sql) {
        // TODO return proper representation object
        return querybean.query(sql);
    }

    /**
     * PUT method for updating or creating an instance of QueryRWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }

}