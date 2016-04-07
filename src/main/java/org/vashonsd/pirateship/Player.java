package org.vashonsd.pirateship;

import org.vashonsd.pirateship.structure.*;

/**
 * The Player is really the keeper of state in this system.
 */

public class Player 
{
	private String name;
	private Location current;
	
	public Player(String name) 
	{
		this.name  = name;
	}
	
	public String toString() 
	{
		return "Player: " + name + "is at location: " + current.getName();
	}

	public void setCurrentLocation(Location next) 
	{
		//current.leave();
		this.current = next;
		next.enter();
	}
	
	public String locationToString()
	{
		return current.toString();
	}
	
	public Location getCurrentLocation()
	{
		return current;
	}
	
}