package org.vashonsd.pirateship.structure;

import java.util.Random;

import org.vashonsd.pirateship.interactions.Interactive;
import org.vashonsd.pirateship.interactions.Request;
import org.vashonsd.pirateship.interactions.Response;

/**
 * The Route class provides us with a connector towards a new Location.
 * Routes are one-way; to return from the new location to the old one, you need another route.
 * 
 */
public class Route implements Interactive {
	private String description;
	
	//	The accessor is the word the user would type to travel through the route, e.g. "east"
	//TODO: for now, the accessor is part of the Route. Consider decoupling them, perhaps by turning the location
	//ArrayList into a HashMap with the accessor as the key.
	private String accessor;
	private double distance;
	private Location destination;
	private String id;
	private String from;

	public Route(String description, String accessor, String from, Location destination) {
		super();
		this.distance = 0;
		this.description = description;
		this.accessor = accessor;
		this.from = from;
		this.destination = destination;
		this.id = from + " - " + destination.getName();
	}

	public Route(String id) {
		super();
		this.id = id;
	}
	
	public Route(String description, String accessor, Location destination, double distance) {
		super();
		this.distance = distance;
		this.description = description;
		this.accessor = accessor;
		this.destination = destination;
	}
	

	public Response handle(Request r) {
		String verb = r.getVerb();
		Response res = new Response("I'm not sure how to do that.", r.getState());
		if (verb.equals("go")) {
			res.setNewLocation(destination);
			res.setText(destination.getDescription());
		}
		return null;
	}
	
	
	public String getDescription() {
		return description + " [" + accessor + "]";
	}
	
	public String getDescriptionNA() {
		return description;
	}

	public Location getDestination() {
		return destination;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	public String getFrom() {
		return this.from;
	}
	
	public String getId() {
		return id;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public void setAccessor(String acc) {
		this.accessor = acc;
	}
	
	public void setDestination(Location destination) {
		this.destination = destination;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public String getAccessor() {
		return accessor;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
