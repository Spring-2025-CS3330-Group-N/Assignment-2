package edu.missouri.groupn.mem;

public class MiddleEarthCharacter {
	public String name;
	public double health;
	public double power;
	
	/**
	 * Parameterized constructor:
	 * This method creates a new MiddleEarthCharacter given the passed arguments.
	 * @param name Name of character
	 * @param health Health level of character
	 * @param power Power level of character
	 */
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}

	@Override
	public String toString() {
		return "MiddleEarthCharacter [name=" + name + ", health=" + health + ", power=" + power + "]";
	}
	
}
