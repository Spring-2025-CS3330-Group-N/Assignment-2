package edu.missouri.groupn.mem.ui;

import edu.missouri.groupn.mem.ArrayList;

/**
 * This class represents an interactive menu.
 * It includes a prompt and list of menu options to choose from.
 */
public class Menu {
	private String prompt;
	private ArrayList options;

	/**
	 * Parameterized constructor:
	 * This method creates an instance of Menu with a given prompt.
	 * @param prompt Prompt for menu
	 */
	public Menu(String prompt) {
		this.prompt = prompt;
		this.options = new ArrayList();
	}
	
	/**
	 * This method adds a new option to options array list.
	 * @param name Name of option
	 * @param key Key associated with the option
	 */
	public void addOption(String name, Object key) {
		this.options.push(new Object[]{name, key});
	}
	
	/**
	 * This method displays the prompt for the menu and all available options.
	 * Prompts user input for choosing a menu option.
	 * @return Key for the chosen menu option upon success, otherwise returns invalid
	 */
	public Object prompt() {
		System.out.println(this.prompt);
		for (var i = 0; i < options.getSize(); ++i) {
			var option = (Object[]) this.options.at(i);
			var name = (String) option[0];
			System.out.println((i + 1) + ": " + name);
		}
		
		if (options.getSize() == 0) {
			return null;
		}
		
		var prompt = "Enter a number from " + 1 + " to " + options.getSize() + ": ";
		var prompter = new Prompter(prompt, new Validator() {
			@Override
			public Object validate(String line, Object invalid) {
				int selection;
				try {
					selection = Integer.parseInt(line) - 1;
				} catch (NumberFormatException e) {
					return invalid;
				}
				if (0 > selection || selection >= options.getSize()) {
					return invalid;
				}
				return selection;
			}
		});
		
		var selection = (int) prompter.prompt();
		var option = (Object[]) this.options.at(selection);
		return option[1];
	}
}
