package edu.missouri.groupn.mem.ui;

import java.util.Scanner;

public class Prompter {
	String prompt;
	Validator validator;
	Object invalid;

	/**
	 * create a prompter
	 * @param prompt a string to display to the user when asking for input
	 * @param validator a strategy for parsing input and determining whether it is valid
	 */
	public Prompter(String prompt, Validator validator) {
		this.prompt = prompt;
		this.validator = validator;
	}

	/**
	 * prompt():
	 * ask the user for input and only return once a valid value has been entered
	 * @return a parsed and validated input casted to the Object base class
	 */
	public Object prompt() {
		var scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print(this.prompt);
			var line = scanner.nextLine();
			var validated = this.validator.validate(line, invalid);
			if (validated != invalid) {
				return validated;
			}
		}
	}
}
