package com.mironov.forum_api;


import com.mironov.forum_api.DAO.TableManager;
import com.mironov.forum_api.Service.Service;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

@Singleton
@Path("/forum")
public class ForumServlet extends HttpServlet {

    private final Service service;
    private final Gson gson = new Gson();

    private class JsonObject{
        int height;
        int weight;
        String name;
    }

    @Inject
    public ForumServlet(Service service){
        this.service=service;
        try {
            //TableManager.resetTable();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        /*
        catch (SQLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

    }
    @GET
    @Path("/{slug}")
    public Response getMsg(@PathParam("slug") String msg)
    {
        String output = "Message requested : " + msg;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/get")
    @Produces("text/plain")
    public String getString()
    {
        return "Hello";
    }


    //Returns List of Json object with fields - forum_api:float,weight:int[kg],name:string,height:int[cm],dateTime:string
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jsonString = gson.toJson(service.getBmiList());
        response.getWriter().write(jsonString);
        request.setAttribute("forum_api", jsonString);
        System.out.println(jsonString);
    }

    //Requires json Object with fields - name:string,weight:int[kg],height:int[cm]
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //get body of request
        String body=getBody(request);
        System.out.println(body);

        //get fields
        final JsonObject obj=gson.fromJson(body,JsonObject.class);

        //add forum_api and check
        try {
            service.saveBmi(obj.name, obj.height, obj.weight);
        } catch (IllegalArgumentException e) {
            response.setStatus(415);
        } catch (SQLException e) {

        }
    }

    private static String getBody(HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }

}
