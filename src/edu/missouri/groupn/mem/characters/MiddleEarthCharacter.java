package edu.missouri.groupn.mem.characters;

public abstract class MiddleEarthCharacter {
	protected String name;
	protected double health;
	protected double power;
	
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
	 * This method prints character details (name, health, and power).
	 */
	public void displayInfo() {
		System.out.println("Name: " + this.name + " | " + this.getRace() + " | Health: " + this.health + " | Power: " + this.power);
	}
	
	/**
	 * getRace():
	 * This method will return the race of the character it's called upon.
	 * Since this is an abstract method, it will be implemented in each of the character subclasses.
	 * @return
	 */
	public abstract String getRace();
	
	/**
	 * attack():
	 * This method will use the character it's called upon to attack the character passed in as an argument.
	 * It will update the target's health level accordingly to reflect the amount of damage inflicted.
	 * Since this is an abstract method, it will be implemented in each of the character subclasses.
	 */
	public abstract boolean attack(MiddleEarthCharacter target);

	@Override
	public String toString() {
		return "MiddleEarthCharacter [name=" + name + ", health=" + health + ", power=" + power + "]";
	}

	/**
	 * getName():
	 * This getter method returns the name of the character it's called upon.
	 * @return Character's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName():
	 * This setter method updates the name of the character it's called upon using the passed argument.
	 * @param name Name to be set for character
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getHealth():
	 * This getter method returns the health level of the character it's called upon.
	 * @return Character's health level
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * setHealth():
	 * This setter method updates the health level of the character it's called upon using the passed argument.
	 * @param health Health level to be set for character
	 */
	public void setHealth(double health) {
		this.health = health;
	}

	/**
	 * getPower():
	 * This getter method returns the power level of the character it's called upon.
	 * @return Character's power level
	 */
	public double getPower() {
		return power;
	}

	/**
	 * setPower():
	 * This setter method updates the power level of the character it's called upon using the passed argument.
	 * @param power Power level to be set for character
	 */
	public void setPower(double power) {
		this.power = power;
	}
	
}
