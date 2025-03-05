package edu.missouri.groupn.mem.ui;

import edu.missouri.groupn.mem.ArrayList;

public class Menu {
	private String prompt;
	private ArrayList options;

	public Menu(String prompt) {
		this.prompt = prompt;
		this.options = new ArrayList();
	}
	
	public void addOption(String name, Object key) {
		this.options.push(new Object[]{name, key});
	}
	
	public Object prompt() {
		System.out.println(this.prompt);
		for (var i = 0; i < options.getSize(); ++i) {
			var option = (Object[]) this.options.at(i);
			var name = (String) option[0];
			System.out.println((i + 1) + ": " + name);
		}
		
		var prompt = "Enter a number from " + 1 + " to " + (options.getSize() + 1) + ": ";
		var prompter = new Prompter(prompt, new Validator() {
			@Override
			public Object validate(String line) {
				int selection;
				try {
					selection = Integer.parseInt(line) - 1;
				} catch (NumberFormatException e) {
					return null;
				}
				if (0 > selection || selection >= options.getSize()) {
					return null;
				}
				return selection;
			}
		});
		
		var selection = (int) prompter.prompt();
		var option = (Object[]) this.options.at(selection);
		return option[1];
	}
}
