package edu.missouri.groupn.mem;

public class MiddleEarthCouncil {
	private CharacterManager characterManager;
	private static MiddleEarthCouncil instance;

	private MiddleEarthCouncil() {
		this.characterManager = new CharacterManager();
	}
	
	public static MiddleEarthCouncil getInstance() {
		if (instance == null) {
			instance = new MiddleEarthCouncil();
		}
		
		return instance;
	}
	
	public CharacterManager getCharacterManager() {
		return this.characterManager;
	}
}
