package edu.missouri.groupn.mem.ui;

import java.util.Scanner;

public class Prompter {
	String prompt;
	Validator validator;
	Object invalid;

	public Prompter(String prompt, Validator validator) {
		this.prompt = prompt;
		this.validator = validator;
	}
	
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
