package edu.missouri.groupn.mem;

import edu.missouri.groupn.mem.characters.Dwarf;
import edu.missouri.groupn.mem.characters.Elf;
import edu.missouri.groupn.mem.characters.Human;
import edu.missouri.groupn.mem.characters.MiddleEarthCharacter;
import edu.missouri.groupn.mem.characters.Orc;
import edu.missouri.groupn.mem.characters.Wizard;
import edu.missouri.groupn.mem.ui.Menu;
import edu.missouri.groupn.mem.ui.Prompter;
import edu.missouri.groupn.mem.ui.Validator;

public class CombatSimulation {
	private Menu mainMenu;
	private Menu kinMenu;
	private CharacterManager characters;

	enum MenuSelection {
		ADD_CHARACTER,
		VIEW_CHARACTERS,
		UPDATE_CHARACTER,
		DELETE_CHARACTER,
		ATTACK,
		EXIT,
	}
	
	enum Kin {
		DWARF,
		ELF,
		HUMAN,
		ORC,
		WIZARD,
	}

	public CombatSimulation() {
		this.mainMenu = new Menu("Select an action.");
		this.mainMenu.addOption("Add a new character.", MenuSelection.ADD_CHARACTER);
		this.mainMenu.addOption("View all characters.", MenuSelection.VIEW_CHARACTERS);
		this.mainMenu.addOption("Update a character.", MenuSelection.UPDATE_CHARACTER);
		this.mainMenu.addOption("Delete a character.", MenuSelection.DELETE_CHARACTER);
		this.mainMenu.addOption("Execute all characters’ attack actions.", MenuSelection.ATTACK);
		this.mainMenu.addOption("Exit.", MenuSelection.EXIT);
		
		this.kinMenu = new Menu("Select a character class.");
		this.kinMenu.addOption("Dwarf", Kin.DWARF);
		this.kinMenu.addOption("Elf", Kin.ELF);
		this.kinMenu.addOption("Human", Kin.HUMAN);
		this.kinMenu.addOption("Orc", Kin.ORC);
		this.kinMenu.addOption("Wizard", Kin.WIZARD);

		this.characters = MiddleEarthCouncil.getInstance().getCharacterManager();
	}

	public void run() {
		while (true) {
			var selection = (MenuSelection) this.mainMenu.prompt();

			switch (selection) {
				case MenuSelection.ADD_CHARACTER:
					this.addCharacter();
					break;
				case MenuSelection.VIEW_CHARACTERS:
					this.viewCharacters();
					break;
				case MenuSelection.UPDATE_CHARACTER:
					this.updateCharacter();
					break;
				case MenuSelection.DELETE_CHARACTER:
					this.deleteCharacter();
					break;
				case MenuSelection.ATTACK:
					break;
				case MenuSelection.EXIT:
					return;
			}
		}
	}
	
	private String getString(String prompt, boolean allowEmpty) {
		var prompter = new Prompter(prompt, new Validator() {	
			@Override
			public Object validate(String line, Object invalid) {
				if (line.length() == 0 && !allowEmpty) {
					return invalid;
				}
				return line;
			}
		});
		return (String) prompter.prompt();
	}

	private double getNonNegativeDouble(String prompt, boolean allowEmpty) {
		var prompter = new Prompter(prompt, new Validator() {	
			@Override
			public Object validate(String line, Object invalid) {
				if (line.length() == 0 && allowEmpty) {
					return 0.;
				}
				
				double number;
				try {
					number = Double.parseDouble(line);
				} catch (NumberFormatException e) {
					return invalid;
				}
				
				if (number <= 0) {
					return invalid;
				}
				return number;
			}
		});
		return (double) prompter.prompt();
	}
	
	private int getNaturalNumber(String prompt, boolean allowEmpty) {
		var prompter = new Prompter(prompt, new Validator() {	
			@Override
			public Object validate(String line, Object invalid) {
				if (line.length() == 0 && allowEmpty) {
					return 0;
				}
				
				int number;
				try {
					number = Integer.parseInt(line);
				} catch (NumberFormatException e) {
					return invalid;
				}
				
				if (number <= 0) {
					return invalid;
				}
				return number;
			}
		});
		return (int) prompter.prompt();
	}
	
	private MiddleEarthCharacter getCharacter(String prompt) {
		this.characters.displayAllCharacters();
		var prompter = new Prompter(prompt, new Validator() {
			@Override
			public Object validate(String line, Object invalid) {
				if (line.length() == 0) {
					return null; // Cancel (in case, for example, there are no characters)
				}

				var character = characters.getCharacter(line);
				if (character != null) {
					return character;
				}
				return invalid;
			}
		});
		
		return (MiddleEarthCharacter) prompter.prompt();
	}

	private void addCharacter() {
		var name = this.getString("Character name: ", false);
		var health = this.getNonNegativeDouble("Character health: ", false);
		var power = this.getNonNegativeDouble("Character power: ", false);
		
		var kin = (Kin) this.kinMenu.prompt();
		
		MiddleEarthCharacter character = null;
		
		switch (kin) {
			case DWARF:
				character = new Dwarf(name, health, power);
				break;
			case ELF:
				character = new Elf(name, health, power);
				break;
			case HUMAN:
				character = new Human(name, health, power);
				break;
			case ORC:
				character = new Orc(name, health, power);
				break;
			case WIZARD:
				character = new Wizard(name, health, power);
				break;
		}
		
		this.characters.addCharacter(character);
	}
	
	private void viewCharacters() {
		this.characters.displayAllCharacters();
	}
	
	private void updateCharacter() {
		var character = this.getCharacter("Enter the name of a character to update or nothing to cancel: ");
		
		if (character == null) {
			System.out.println("Action cancelled.");
			return;
		}
		
		var name = this.getString("Character name (or nothing): ", true);
		var health = this.getNaturalNumber("Character health (or nothing): ", true);
		var power = this.getNaturalNumber("Character power (or nothing): ", true);
		
		this.characters.updateCharacter(
			character,
			(name.length() == 0)? character.getName() : name,
			(health == 0)? (int) Math.round(character.getHealth()) : health,
			(power == 0)? (int) Math.round(character.getPower()) : power
		);
	}
	
	private void deleteCharacter() {
		var character = this.getCharacter("Enter the name of a character to delete or nothing to cancel: ");
		
		if (character == null) {
			System.out.println("Action cancelled.");
			return;
		}
		
		this.characters.deleteCharacter(character);
	}
}
