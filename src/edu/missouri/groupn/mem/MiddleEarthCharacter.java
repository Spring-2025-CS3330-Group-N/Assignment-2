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
	
	/**
	 * displayInfo():
	 * This method prints character details.
	 */
	public void displayInfo() {
		System.out.println("Name: " + this.name + " | Health: " + this.health + " | Power: " + this.power);
//		System.out.println("Health: " + this.health);
//		System.out.println("Power: " + this.power);
	}

	@Override
	public String toString() {
		return "MiddleEarthCharacter [name=" + name + ", health=" + health + ", power=" + power + "]";
	}
	
}
