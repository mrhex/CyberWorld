package ua.kiev.cyberworld.computer;

/**
 * Represents memory. Provides reading and writing methods and device mapping.
 * 
 * @param <T>
 *            type for memory cell
 */
public interface Memory<T> {
	/**
	 * Writes value to the memory cell with specified address.
	 * 
	 * @param addr
	 *            address of the memory cell
	 * @param val
	 *            new value for memory cell
	 */
	public void set(int addr, T val);

	/**
	 * Reads and returns value of the memory cell with specific address
	 * 
	 * @param addr
	 *            address of the memory to read.
	 * @return value of the memory cell
	 */
	public T get(int addr);

	/**
	 * Mounts chip to the memory. When specified address is read/written the
	 * chip should be fired in according with its' trigger configuration.
	 * 
	 * @param addr
	 *            address of the mount point of a chip
	 * @param chip
	 *            chip to be mounted
	 */
	public void addDevice(int addr, Chip<T> chip);
}
