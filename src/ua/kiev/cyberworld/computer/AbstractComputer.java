package ua.kiev.cyberworld.computer;

/**
 * Implements memory storage functionality of <code>Computer</code> interface
 * @author lk
 *
 * @param <T> type of the memory cell
 */
public abstract class AbstractComputer<T> implements Computer<T> {

	protected Memory<T> mem;
	
	/**
	 * Creates new computer with specific memory
	 * @param memory to be set to new computer
	 */
	public AbstractComputer(Memory<T> memory) {
		setMemory(memory);
	}
	
	@Override
	public void setMemory(Memory<T> memory) {
		mem = memory;
	}
	
}
