package hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.xml.bind.JAXBElement;


@Path("/athletes")
public class RegistrationService {
	
	private static Map<Integer, Athlete> athletes = new HashMap<Integer, Athlete>();
	
	@Context
    UriInfo uriInfo;
	
	public RegistrationService() {
		if (athletes.isEmpty()) {
	        athletes.put(1, new Athlete(1, "Athlete Strong", "abc@yahoo.com", 187));
	        athletes.put(2, new Athlete(2, "Athlete Tall", "def@xyz.com", 210));
	    }
	}


	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Athlete> getRegisteredAthletes() {
	    List<Athlete> registeredAthletes = new ArrayList<Athlete>();
	    registeredAthletes.addAll( athletes.values() );
	    return registeredAthletes;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{athleteId}")
	public Athlete getRegisteredAthlete(@PathParam("athleteId") String athleteId) {
		int id = Integer.parseInt(athleteId);
        Athlete athlete = athletes.get(id);
        return athlete;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{athleteId}")
	public Response updateAthlete(@PathParam("athleteId") String athleteId, JAXBElement<Athlete> athleteElement) {
	    int pathId = Integer.parseInt(athleteId);
	    Athlete athlete = athleteElement.getValue();

	    if (athlete.getID() != pathId) {
	        return Response.status(Response.Status.CONFLICT)
	                .entity("IDs do not match").build();
	    }

	    athletes.put(pathId, athlete);

	    return Response.noContent().build();
	}


    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response addAthlete(JAXBElement<Athlete> athleteElement) {
        Athlete athlete = athleteElement.getValue();
        int id = athlete.getID();

        if (athletes.containsKey(id)) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("Athlete with ID "+ id +" already exists").build();
        }

        athletes.put(athlete.getID(), athlete);

        return Response.created(uriInfo.getAbsolutePath()).build();
    }
    
    @DELETE
    @Path("{athleteId}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response removeRegisteredAthlete(@PathParam("athleteId") String athleteId) {
        int id = Integer.parseInt(athleteId);
        
        Athlete removed = athletes.remove(id);

        if (removed == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Athlete with ID " + id + " was not found.").build();
        }

        return Response.noContent().build();
    }
}