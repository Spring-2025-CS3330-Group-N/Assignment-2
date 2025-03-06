package edu.missouri.groupn.mem;

public class CombatSystem {
	ArrayList damageRules;
	ArrayList classes;

	private static CombatSystem instance;

	/**
	 * create a combat system object
	 */
	private CombatSystem() {
		this.damageRules = new ArrayList();
		this.classes = new ArrayList();
	}

	/**
	 * getInstance()
	 * @return the instance of the combat system if it exists
	 */
	public static CombatSystem getInstance() {
		if (instance == null) {
			instance = new CombatSystem();
		}
		return instance;
	}

	/**
	 * addClass():
	 * @param c a class to add to the combat system. Note that the order
	 * in which classes are added to the combat system determines
	 * the effectiveness of attacks!
	 */
	public void addClass(Class c) {
		this.classes.push(c);
	}

	/**
	 * addDamageRule()
	 * @param stride for any class at index i, that class's attacks are boosted
	 * by multiplier against the class at i + stride. This is the q parameter of
	 * https://en.wikipedia.org/wiki/Regular_polygon#Regular_star_polygons
	 * @param multiplier the amount to boost attack damage against affected classes by
	 */
	public void addDamageRule(int stride, double multiplier) {
		this.damageRules.push(new Object[]{stride, multiplier});
	}

	/**
	 * getDamageMultiplier()
	 * @param a the class of the character initiating the attack
	 * @param b the class of the character receiving the attack
	 * @return the effectiveness of the attack, as a multiplier of a's power
	 */
	public double getDamageMultiplier(Class a, Class b) {
		int aCombatId = this.classes.find(a);
		int bCombatId = this.classes.find(b);

		if (aCombatId < 0) {
			throw new RuntimeException("Could not find " + a + " in the combat system.");
		}
		if (bCombatId < 0) {
			throw new RuntimeException("Could not find " + b + " in the combat system.");
		}

		double multiplier = 0;
		for (int ri = 0; ri < this.damageRules.getSize(); ++ri) {
			var rule = (Object[]) this.damageRules.at(ri);
			var ruleStride = (int) rule[0];
			var ruleMultiplier = (double) rule[1];

			if (Math.floorMod(aCombatId + ruleStride, this.classes.getSize()) == bCombatId) {
				multiplier += ruleMultiplier;
			}
		}
		return multiplier;
	}
}
