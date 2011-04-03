package ua.kiev.cyberworld.computer;

/**
 *  Changes memory state by instruction execution 
 * @author lk
 *
 * @param <T> type of the memory cell
 */
public interface Computer<T> {
	/**
	 * Set memory to this computer.
	 * @param memory 
	 */
	public void setMemory(Memory<T> memory);
	/**
	 * Reads end execute next instruction
	 * @return <code>false</code> when stop command or error happend
	 */
	public boolean tick();
}
