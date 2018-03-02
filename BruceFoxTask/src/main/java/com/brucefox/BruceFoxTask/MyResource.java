
package com.brucefox.BruceFoxTask;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.brucefox.dao.TaskDaoImpl;
import com.brucefox.dao.TaskDao;
import com.brucefox.model.Task;


@Path("/task")
public class MyResource {
	
	private TaskDao taskDAO;

    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
    
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWelcomeMessageJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		taskDAO = new TaskDaoImpl();
		List<Task> task = taskDAO.getEntityList();
	   String arrayToJson = objectMapper.writeValueAsString(task);
	   return Response.ok( arrayToJson ).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTask(Task task){
		System.out.println("try");
		try {
			taskDAO = new TaskDaoImpl();
			taskDAO.addEntity(task);
			System.out.println("Add");
			return Response.status(200).entity("Task added successfully").header("Access-Control-Allow-Origin", "*").build();
		} catch (Exception e) {
			return Response.serverError().entity("Task not added").header("Access-Control-Allow-Origin", "*").build();
		}
	}
	
	@POST
	@Path("/update")
	@Consumes("application/json")
	public Response updateTask(Task task) {
		try {
			taskDAO = new TaskDaoImpl();
			taskDAO.updateTask(task);
			return Response.status(200).entity("Task updated successfully").build();
		} catch (Exception e) {
			return Response.serverError().entity("Task not updated added").build();
		}
	}
}
