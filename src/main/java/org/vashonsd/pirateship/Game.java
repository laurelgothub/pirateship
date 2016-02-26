package org.vashonsd.pirateship;

import java.io.IOException;
import java.util.HashMap;

import org.vashonsd.pirateship.io.*;
import org.vashonsd.pirateship.structure.*;

public class Game {
	private StringRead reader;
	private StringWrite writer;
	
	private World thisWorld;
	
	private Player player;
	private String quitWord = "exit";
	private String rudeQuit = "scram";
	private String inventory = "inventory";
	private HashMap<String, String> miscCommands;
	
	public Game(String world) {
		super();
    	thisWorld = WorldBuilder.makeWorld(world);
    	player = new Player("Ronaldo");
    	player.setCurrentLocation(thisWorld.getStartingLocation());
    	
    	miscCommands = new HashMap<String, String>();
    	putCommands();
    	
    	reader = new UserInput();
    	writer = new ConsoleOut();
	}
	
	public void Run() throws IOException {
		while(true) {
        	writer.write(player.getCurrentLocation().toString());
        	String command = getCommand();
        	evalCommand(command);
		}
	}
	
	/*
     * Gets the player's command, checking for valid/invalid input.
     */
    public String getCommand() throws IOException {
    	while(true) {
    		String command = reader.read();
    		command = command.toLowerCase();
    		if (command.equals(quitWord)) { quitGracefully(); };
    		if (command.equals(rudeQuit)) { quitRudely(); };
    		if (command.equals(inventory)) {
    			writer.write(player.getInventory().toString());
    			}
    		else if (player.getCurrentLocation().commandAvailable(command)) {
    			return command;
    		}
    		else if (miscCommands.containsKey(command)) {
    			writer.write(miscCommands.get(command) + "\n");
    		}
    		else {
    			writer.write("I'm sorry, I don't recognize " + command + "...\n");
    		}
    	}
    }
    
    public void evalCommand(String c) {
    	player.setCurrentLocation(player.getCurrentLocation().travel(c));
    }
    
    public void quitGracefully() throws IOException {
    	writer.write("Thank you for exploring " + thisWorld.getName() +".");
    	System.exit(1);
    }
    
    public void quitRudely() throws IOException {
    	writer.write("Fine, I didn't want to hang with you either.");
    	System.exit(1);
    }
    
    private void putCommands() {
    	miscCommands.put("dance", "You do a dance. Not a fabulous dance. Just a regular dance.");
    	miscCommands.put("dance fabulously", "You dance like a rock star. Crowds gather to watch your performance.");
    	miscCommands.put("pick nose", "You pick your nose without shame. Who cares who's watching?");
    	miscCommands.put("depants", "You strip yourself of those cumbersome pants. A feeling of freedom washes over you.");
    	miscCommands.put("twiddle thumbs", "You stand around and look bored, like a loser.");
    	miscCommands.put("do nothing", "As expected, nothing happens.");
    	miscCommands.put("strike pose", "You strike a weak pose. It's not very impressive.");
    	miscCommands.put("strike dramatic pose", "You strike a dramatic pose. People are awed by your rad style.");
    	miscCommands.put("complain", "You complain. No one cares.");
    	miscCommands.put("sass", "You say something sassy and snap your fingers. No one is impressed");
    	miscCommands.put("cry", "You cry salty tears of sadness. No one cares.");
    	miscCommands.put("die", "You try to die with pure willpower alone. It doesn't work.");
    	miscCommands.put("sing", "You sing a little tune. Your singing sucks.");
    	miscCommands.put("sing beautifully", "You break out into a gorgeous ballad. Everyone stops to listen.");
    }
}
