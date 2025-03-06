package edu.missouri.groupn.mem;

import edu.missouri.groupn.mem.characters.Dwarf;
import edu.missouri.groupn.mem.characters.Elf;
import edu.missouri.groupn.mem.characters.Human;
import edu.missouri.groupn.mem.characters.Orc;
import edu.missouri.groupn.mem.characters.Wizard;

public class MiddleEarthApp {
	public static void main(String[] args) {
		var combatSystem = CombatSystem.getInstance();

		combatSystem.addClass(Dwarf.class);
		combatSystem.addClass(Elf.class);
		combatSystem.addClass(Orc.class);
		combatSystem.addClass(Human.class);
		combatSystem.addClass(Wizard.class);

		combatSystem.addDamageRule(1, 1.5);
		combatSystem.addDamageRule(2, 1);
		combatSystem.addDamageRule(-2, 1);
		
		var simulation = new CombatSimulation();
		simulation.run();
	}
}
