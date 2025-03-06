package edu.missouri.groupn.mem.characters;

import edu.missouri.groupn.mem.CombatSystem;

/**
 * Dwarf is child class of MiddleEarthCharacter.
 */
public class Dwarf extends MiddleEarthCharacter {

	/**
	 * Parameterized constructor:
	 * This creates an instance of the Dwarf character type.
	 * @param name Name
	 * @param health Health level
	 * @param power Power level
	 */
	public Dwarf(String name, double health, double power) {
		super(name, health, power);
	}

	/**
	 * This method returns a String with the race of the character.
	 * In this case, it will return "Dwarf".
	 */
	@Override
	public String getRace() {
		return this.getClass().getSimpleName();
	}

	/**
	 * This method utilizes the CombatSystem to fetch the required combat rules and apply them accordingly.
	 * It calculates attack damage for the target based on the attacking character's demographics.
	 * The target's health level is updated to reflect damage done by the attacking character.
	 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		var multiplier = CombatSystem.getInstance().getDamageMultiplier(this.getClass(), target.getClass());
		var damage = multiplier * this.power;
		target.setHealth(target.getHealth() - damage);

		return damage > 0;
	}
	
}
