package edu.missouri.groupn.mem.characters;

import edu.missouri.groupn.mem.MiddleEarthCharacter;

public class Wizard extends MiddleEarthCharacter {

	public Wizard(String name, double health, double power) {
		super(name, health, power);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getRace() {
		return this.getClass().getSimpleName();
	}

	@Override
	public boolean attack(MiddleEarthCharacter target) {
		// TODO Auto-generated method stub
		return false;
	}

}
