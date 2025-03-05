package edu.missouri.groupn.mem;

public class ArrayList {
	private Object[] array;
	private int size;

	public ArrayList() {
		this(1);
	}

	public ArrayList(int initialCapacity) {
		this.array = new Object[initialCapacity];
		this.size = 0;
	}

	private void doubleCapacity() {
		var newArray = new Object[this.array.length * 2];
		for (var i = 0; i < this.size; ++i) {
			newArray[i] = this.array[i];
		}
		this.array = newArray;
	}

	public int getSize() {
		return this.size;
	}

	public Object at(int index) {
		return this.array[index]; // throw the usual errors
	}

	public int find(Object item) {
		for (var i = 0; i < this.size; ++i) {
			if (this.array[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	public void push(Object item) {
		if (this.size == this.array.length) {
			this.doubleCapacity();
		}

		this.array[this.size++] = item;
	}
	
	public void pop(int index) {
		for (var i = index; i < this.size - 1; ++i) {
			this.array[i] = this.array[i+1];
		}

		this.array[this.size--] = null;
	}
}
