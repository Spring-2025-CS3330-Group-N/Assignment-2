package edu.missouri.groupn.mem;

public class CombatSystem {
	ArrayList damageRules;
	ArrayList classes;

	private static CombatSystem instance;

	private CombatSystem() {
		this.damageRules = new ArrayList();
		this.classes = new ArrayList();
	}

	public static CombatSystem getInstance() {
		if (instance == null) {
			instance = new CombatSystem();
		}
		return instance;
	}

	public void addClass(Class c) {
		this.classes.push(c);
	}

	public void addDamageRule(int stride, double multiplier) {
		this.damageRules.push(new Object[]{stride, multiplier});
	}

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
