package edu.missouri.groupn.mem;

/**
 * This class is our own custom version of ArrayList.
 * Its members includes an array and an integer representing the size of the array.
 */
public class ArrayList {
	private Object[] array;
	private int size;

	public ArrayList() {
		this(1);
	}

	/**
	 * Parameterized constructor:
	 * This method creates an ArrayList object with an initial capacity of the value passed in as an argument.
	 * The size is set to 0 since the array is empty upon creation.
	 * @param initialCapacity Starting size for the array
	 */
	public ArrayList(int initialCapacity) {
		this.array = new Object[initialCapacity];
		this.size = 0;
	}

	/**
	 * This method resizes the array by doubling its current size.
	 */
	protected void doubleCapacity() {
		var newArray = new Object[this.array.length * 2];
		for (var i = 0; i < this.size; ++i) {
			newArray[i] = this.array[i];
		}
		this.array = newArray;
	}

	/**
	 * This getter method returns the size of the array.
	 * @return Size of the array
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * This method retrieves an item in the array given its index.
	 * @param index Index of array item
	 * @return Item at the given array index
	 */
	public Object at(int index) {
		return this.array[index]; // throw the usual errors
	}

	/**
	 * This method searches the array to find a given item's index.
	 * @param item Object to be searched for in the array
	 * @return Item's index value upon success, returns -1 if item is not found in the list
	 */
	public int find(Object item) {
		for (var i = 0; i < this.size; ++i) {
			if (this.array[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This method adds an item to the array and dynamically resizes the array to accommodate more items if it's full.
	 * @param item Item to add to the array
	 */
	public void push(Object item) {
		if (this.size == this.array.length) {
			this.doubleCapacity();
		}

		this.array[this.size++] = item;
	}
	
	/**
	 * This method removes an item from the array given its position in the array (index).
	 * @param index Index of the item to be removed
	 */
	public void pop(int index) {
		for (var i = index; i < this.size - 1; ++i) {
			this.array[i] = this.array[i+1];
		}

		this.array[this.size--] = null;
	}
}
