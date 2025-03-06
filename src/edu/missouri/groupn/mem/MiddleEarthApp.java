package edu.missouri.groupn.mem;

//import edu.missouri.groupn.mem.characters.Dwarf;
//import edu.missouri.groupn.mem.characters.Elf;
//import edu.missouri.groupn.mem.characters.Human;
//import edu.missouri.groupn.mem.characters.Orc;
//import edu.missouri.groupn.mem.characters.Wizard;
import edu.missouri.groupn.mem.characters.*;

public class MiddleEarthApp {
	public static void main(String[] args) {
		// test code for simulation
//		var combatSystem = CombatSystem.getInstance();
//
//		combatSystem.addClass(Dwarf.class);
//		combatSystem.addClass(Elf.class);
//		combatSystem.addClass(Orc.class);
//		combatSystem.addClass(Human.class);
//		combatSystem.addClass(Wizard.class);
//
//		combatSystem.addDamageRule(1, 1.5);
//		combatSystem.addDamageRule(2, 1);
//		combatSystem.addDamageRule(-2, 1);
//
//		var wizard = new Wizard("harry", 10, 1);
//		var dwarf = new Dwarf("grumpy", 10, 1);
//
//		System.out.println(wizard.getHealth());
//		
//		var simulation = new CombatSimulation();
//		simulation.run();
		
		// test output for class constructor
		var human = new Human("NPC", 50, 10);
		System.out.println("Character created!");
		
		human.displayInfo();
		
		// test Elf subclass with MiddleEarthCharacter methods
		var elf = new Elf("Marcille", 80, 20);
		
		elf.displayInfo();
		var testGetRace = elf.getRace();
		System.out.println("\ngetRace() returns " + testGetRace + " for " + elf.getName());
		
		// test character management system
		var characterManager = new CharacterManager();
		characterManager.displayAllCharacters();
		
		// add character
		var ec = characterManager.addCharacter(elf);
		System.out.println("addCharacter() returns " + ec + "\n");
		
		characterManager.displayAllCharacters();
		
		// get character by name
		var testVar2 = characterManager.getCharacter("Marcille");
		System.out.println("getCharacter returns " + testVar2);
				
		testVar2 = characterManager.getCharacter("marcille");
		System.out.println("getCharacter returns " + testVar2 + "\n");
		
		// add other subclasses to system
	
		var dwarf = new Dwarf("Doug", 120, 20);
		characterManager.addCharacter(dwarf);
		
		var orc = new Orc("Odin", 200, 50);
		characterManager.addCharacter(orc);
		
		var wizard = new Wizard ("Merlin", 175, 35);
		characterManager.addCharacter(wizard);
		
		// characterManager.addCharacter(human);
		
		characterManager.displayAllCharacters();
		
		// test getRace() method
		System.out.println("\n");
		for (int i=0; i<characterManager.size; i++) {
			// must cast MiddleEarthType
			var character = (MiddleEarthCharacter) characterManager.characters.at(i);
			testGetRace = character.getRace();
			System.out.println("getRace() returns " + testGetRace + " for " + character.getName());
		}
		System.out.println("\n");
		
		// test updateCharacter() method:
		
		// invalid character -- not in system
		 ec = characterManager.updateCharacter(human, "Doug", 120, 20);
		
		// character with arguments == to their current stats (nothing to update)
		 ec = characterManager.updateCharacter(dwarf, "Doug", 120, 20);
		
		// valid change
		ec = characterManager.updateCharacter(dwarf, "Dwight", 120, 20);
		// System.out.println("updateCharacter returns " + ec + "\n");
	
	}
}
