package edu.missouri.groupn.mem.characters;

import edu.missouri.groupn.mem.MiddleEarthCharacter;

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
		for (int i=0; i<this.size; i++) {
			if (this.characters[i].name.equalsIgnoreCase(name))
				System.out.println("Found " + name + " in the system!");
				return this.characters[i];
		}
		System.out.print("No characters named " + name + " were found in the system.");
		return null;
	}
}
