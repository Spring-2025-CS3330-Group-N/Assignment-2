package edu.missouri.groupn.mem;

import edu.missouri.groupn.mem.characters.MiddleEarthCharacter;

public class CharacterManager {
	public MiddleEarthCharacter[] characters = new MiddleEarthCharacter[5];
	public int size = 0;
	
	/**
	 * addCharacter():
	 * This method adds a character to the character array and doubles array size if full.
	 * @param c Character to be added
	 * @return True if addition is successful, otherwise return False
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		// check if array is full
		if (this.characters.length == this.size) {
			// logic for doubling the array -- create and call a separate method created to handle that?
			// just return false for now, will add dynamic resize feature later
			System.out.println("The system is full -- try again later.");
			return false;
		}
		this.characters[this.size] = c;
		this.size++;
		System.out.println("Success! " + c + " added to the system.");
		return true;
	}
	
	/**
	 * getCharacter():
	 * This method retrieves a character associated with the name argument provided from the character management system.
	 * @param name Character name
	 * @return the requested MiddleEarthCharacter upon success, otherwise return null
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		System.out.println("\nSearching for " + name + "...");
		
		for (int i=0; i<this.size; i++) {
			if (this.characters[i].getName().equalsIgnoreCase(name)) {
				System.out.println("Found " + name + " in the system!");
				return this.characters[i];
			}
		}
		System.out.print("No characters named " + name + " were found in the system.\n");
		return null;
	}
	
	/**
	 * updateCharacter():
	 * This method updates a given character with the passed argument values.
	 * @param character Character to be updated
	 * @param name Character name
	 * @param health Character health level 
	 * @param power Character power level
	 * @return True upon successful change, returns False if there is no change or if the character does not exist
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		// search character management system for the given character
		for (int i=0; i<this.size; i++) {
			if (this.characters[i].equals(character)) {
				// variable to compare argument values to those already stored for the character
				// if unique, update character with the new value
				var uniqueVal = false; 
				
				// check for unique name
				if (!(this.characters[i].getName().equalsIgnoreCase(name))) {
					uniqueVal = true;
					this.characters[i].setName(name);
				}
				// check for unique health level
				if (this.characters[i].getHealth() != health) {
					uniqueVal = true;
					this.characters[i].setHealth(health);
				}
				// check for unique power level
				if (this.characters[i].getPower() != power) {
					uniqueVal = true;
					this.characters[i].setPower(power);
				}
				
				// check uniqueVal
				if (uniqueVal == true) {
					System.out.println("Update successful! See new character stats below.");
					this.characters[i].displayInfo();
					System.out.println("\n");
					return true;
				}
				else {
					System.out.println("There is nothing to change or update for " + this.characters[i].getName());
					System.out.println("Try again with different arguments for name, health, or power.\n");
					return false;
				}
			}
		}
		System.out.print(character + " was not found. You must add characters to the system before you can update them.\n");
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
		}
		else {
			System.out.println("\nThere are currently " + this.size + " characters in the system:\n");
			}
		// print character(s)
		for (int i=0; i<this.size; i++) {
			this.characters[i].displayInfo();
		}
	}
}
