package edu.missouri.groupn.mem.characters;

import edu.missouri.groupn.mem.CombatSystem;

public class Orc extends MiddleEarthCharacter {

	public Orc(String name, double health, double power) {
		super(name, health, power);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getRace() {
		return this.getClass().getSimpleName();
	}

	@Override
	public boolean attack(MiddleEarthCharacter target) {
		var multiplier = CombatSystem.getInstance().getDamageMultiplier(this.getClass(), target.getClass());
		var damage = multiplier * this.power;
		target.setHealth(target.getHealth() - damage);

		return damage > 0;
	}

}
