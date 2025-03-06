package edu.missouri.groupn.mem;

import edu.missouri.groupn.mem.characters.MiddleEarthCharacter;

public class CharacterManager {
	// creates a list of characters with an initial capacity of 5
	protected ArrayList characters = new ArrayList(5);
	protected int size = 0;
	// size variable is also included in our custom ArrayList class!
	
	/**
	 * addCharacter():
	 * This method adds a character to the character array and doubles array size if full.
	 * @param c Character to be added
	 * @return True if addition is successful, otherwise return False
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		// search array for duplicate entry
		for (int i=0; i<this.characters.getSize(); i++) {
			// cast MiddleEarthCharacter type
			var existingChar = (MiddleEarthCharacter) this.characters.at(i);

			// check for duplicate
			if (existingChar.equals(c) && (existingChar.getRace() == c.getRace())) {
				System.out.println("Character addition failed. Cannot add characters that already exist in the system.\n");
				return false;
			}
		}
		// push() method includes conditions for dynamic array resizing
		this.characters.push(c); 
		this.size++;
		System.out.println("Success! " + c + " added to the system.");
		return true;
	}
	
	/**
	 * getCharacter():
	 * This method retrieves a character associated with the name argument provided from the character management system.
	 * If there is more than one character with the same name in the system, from the eligible characters it will return the instance that was added to the system first.
	 * @param name Character name
	 * @return Requested character upon success, otherwise return null
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		System.out.println("\nSearching for " + name + "...");
		
		for (int i=0; i<this.characters.getSize(); i++) {
			// must cast MiddleEarthCharacter type here to use getter methods from that class
			var character = (MiddleEarthCharacter) this.characters.at(i);
			
			if (character.getName().equals(name)) {
				System.out.println("Found " + name + " in the system!");
				return character;
			}
		}
		System.out.print("No characters named " + name + " were found in the system.\n");
		return null;
	}
	
	/**
	 * This method updates a given character with the passed argument values.
	 * @param character Character to be updated
	 * @param name Character name
	 * @param health Character health level 
	 * @param power Character power level
	 * @return True upon successful change, returns False if there is no change or if the character does not exist
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		System.out.println("Character to be updated: ");
		character.displayInfo();
		
		// search character management system for the given character
		// find() returns the index
		var charIndex = this.characters.find(character);
		
		// check for valid index (AKA character exists in the array)
		if (charIndex != -1) {
			// must cast MiddleEarthCharacter type here to use getter/setter methods from that class
			var existingCharacter = (MiddleEarthCharacter) this.characters.at(charIndex);
			
			// variable to compare argument values to those already stored for the character
			// if unique, update character with the new value
			var uniqueVal = false; 
			
			// check for unique name
			if (! existingCharacter.getName().equals(name)) {
				uniqueVal = true;
				existingCharacter.setName(name);
			}
			// check for unique health level
			if (existingCharacter.getHealth() != health) {
				uniqueVal = true;
				existingCharacter.setHealth(health);
			}
			// check for unique power level
			if (existingCharacter.getPower() != power) {
				uniqueVal = true;
				existingCharacter.setPower(power);
			}
			
			// check uniqueVal
			if (uniqueVal == true) {
				System.out.println("Update successful! See new character stats below.");
				existingCharacter.displayInfo();
				System.out.println("\n");
				return true;
			}
			else {
				System.out.println("There is nothing to change or update for " + existingCharacter.getName());
				System.out.println("Try again with different arguments for name, health, or power.\n");
				return false;
			}
		}
		System.out.print(character + " was not found. You must add characters to the system before you can update them.\n");
		return false;
	}
	
	/**
	 * This method deletes a given character and shifts character array elements accordingly.
	 * @param character Character to be deleted
	 * @return True upon successful deletion, false if the character is not in the array
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		System.out.println("Character to be deleted:");
		character.displayInfo();
		
		// search array for given character
		for (int i=0; i<this.characters.getSize(); i++) {
			// cast MiddleEarthCharacter type
			var characterToDelete = (MiddleEarthCharacter) this.characters.at(i);
			
			// check for a match
			if (characterToDelete.equals(character)) {
				// pop() method deletes character at the given index and shifts array elements
				this.characters.pop(i);
				this.size--;
				System.out.println("Character successfully deleted!\n");
				return true;
			}
		}
		System.out.println("Character not found. You must add characters to the system before you can delete them.\n");
		return false;
	}
	
	/**
	 * displayAllCharacters():
	 * This method displays information for all characters in the management system.
	 */
	public void displayAllCharacters() {
		if (this.size == 0) {
			System.out.println("\nThe character management system is empty! Add character(s) and try again.\n");
			return;
		}
		 
		// adjust grammar based on how many characters are in the system
		if (this.size == 1) {
			System.out.print("\nThere is currently " + this.size + " character in the system.\n");
			// must cast MiddleEarthCharacter type here to use methods from that class
			var character = (MiddleEarthCharacter) this.characters.at(size-1);
			character.displayInfo();
		}
		else {
			System.out.println("\nThere are currently " + this.size + " characters in the system:\n");
			// print character(s)
			for (int i=0; i<this.characters.getSize(); i++) {
				// must cast MiddleEarthCharacter type here to use methods from that class
				var character = (MiddleEarthCharacter) this.characters.at(i);
				character.displayInfo();
			}
		}
	}
}
