package org.vashonsd.pirateship.creature;

import java.util.Random;

public class BuffSpeech implements SpeechBehavior {

	public String intro(Creature c) {
		return " becomes enamored by his own muscles.";
	}

	public String approach(Creature c) {
		return " flexes his way towards you.";
	}

	public String idle(Creature c) {
		if (c.getHealth() < (c.getMaxHealth() / 2)) {
			return c.getName() + " is trying to be intimidating.";
		}
		Random ran = new Random();
		int x = ran.nextInt(3);
		String text = c.getName();
		if (x == 0) {
			text += " is trying to flex all his muscles at once.";
		} else if (x == 1) {
			text += " does mad bench presses.";
		} else if (x == 2) {
			text += " breaks rocks between his teeth.";
		}
		return text;
	}

	public String speak(Creature c) {
		if (c.getHealth() < (c.getMaxHealth() / 2)) {
			return c.getName() + " just growls at you.";
		}
		Random ran = new Random();
		int x = ran.nextInt(3);
		String text = c.getName();
		if (x == 0) {
			text += " brags about his beefy muscles. Extensively.";
		} else if (x == 1) {
			text += " claims he could do pushups with both his hands behind his back.\nHe stops to consider that.";
		} else if (x == 2) {
			text += " accidentally lets slip he likes a girly TV show, then scrambles to correct his mistake.";
		}
		return text;
	}

	public String exit(Creature c) {
		return c.getName() + " flexes away.";
	}

	public String failText(Creature c) {
		return c.getName() + " doesn't understand, but pretends like he does.";
	}

}
