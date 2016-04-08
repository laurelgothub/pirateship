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
    		if (player.getCurrentLocation().commandAvailable(command)) {
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
    	miscCommands.put("pose", "You strike a weak pose. It lacks dramatic flair and is not very impressive.");
    	miscCommands.put("pose dramatically", "You strike a dramatic pose. People are awed by your rad style.");
    	miscCommands.put("complain", "You complain. No one cares.");
    	miscCommands.put("sass", "You say something sassy and snap your fingers. No one is impressed");
    	miscCommands.put("cry", "You cry salty tears of sadness. No one cares.");
    	miscCommands.put("live", "Life says 'no' and then kills you.");
    	miscCommands.put("die", "You try to die with pure willpower alone. It doesn't work.");
    	miscCommands.put("sing", "You sing a little tune. Your singing sucks.");
    	miscCommands.put("sing beautifully", "You break out into a gorgeous ballad. Everyone stops to listen.");
    	miscCommands.put("faceplant", "You take a dramatic tumble, face smashing into the ground. It's an improvement, to say the least.");
    	miscCommands.put("try", "You fail.");
    	miscCommands.put("try hard", "You fail hard.");
    	miscCommands.put("contemplate", "No, no, that's too difficult for you. Don't hurt yourself.");
    	miscCommands.put("contemplate life", "You come to the conclusion that life is a dark, sad place without hope. You weep.");
    	miscCommands.put("strut", "You strut about like a model on a walkway. People start snapping pictures.");
    	miscCommands.put("suffer", "Such is life.");
    	miscCommands.put("sleep", "For whatever reason, you decide that now is a good time for a nap, and fall asleep while standing. People think you're weird.");
    	miscCommands.put("shout", "You shout out to the world, begging to be heard. No one cares.");
    	miscCommands.put("backflip", "You attempt a backflip, only to fall and break your neck. Whoops.");
    	miscCommands.put("rap", "You attempt to convince people you're from the hood by belting out a quick rap. No one is impressed.");
    	miscCommands.put("fail", "You think that maybe you should try doing something else with your life.");
    	miscCommands.put("laugh", "You break out into laughter fpr no reason. People start giving you a wide berth.");
    	miscCommands.put("fly", "You jump around and flap your arms frantically. All you accomplish is looking stupid.");
    	miscCommands.put("learn", "You learn that you are bad at learning.");
    	miscCommands.put("smile", "Your smile is scaring children, please stop.");
    	miscCommands.put("no", "Don't you say no to me.");
    }
}
