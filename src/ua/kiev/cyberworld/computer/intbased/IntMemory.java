package ua.kiev.cyberworld.computer.intbased;

import java.util.Arrays;
import java.util.Collections;

import ua.kiev.cyberworld.computer.AbstractMemory;
/**
 * <code>ArrayList</code> implementation of the memory with <code>Integer</code> based cells
 * @author lk
 *
 */
public class IntMemory extends AbstractMemory<Integer> {
	private int size;
	public IntMemory(int size) {
		super(size);
		this.size = size;
		fill(0);
	}
	
	/**
	 * Fills memory with specific value
	 * @param val value for all memory cells
	 */
	private void fill(int val) {
		Integer[] arr = new Integer[size];
		Arrays.fill(arr,val);
		Collections.addAll(mem, arr);
	}
}
