package edu.missouri.groupn.mem;

import java.util.Scanner;

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
		
		var scanner = new Scanner(System.in);
		int selection;
		while (true) {
			System.out.print("Enter a number from " + 1 + " to " + (options.getSize() + 1) + ": ");
			var line = scanner.nextLine();
			try {
				selection = Integer.parseInt(line) - 1;
			} catch (NumberFormatException e) {
				continue;
			}
			if (0 <= selection && selection < this.options.getSize()) {
				break;
			}
		}
		
		var option = (Object[]) this.options.at(selection);
		return option[1];
	}
}
