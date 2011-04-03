package ua.kiev.cyberworld.computer;

/**
 * Extends computer functionality and/or provide communication with devices.
 * 
 * @author lk
 * 
 * @param <T>
 *            type of the memory cell
 */
public interface Chip<T> {
	/**
	 * Calls the chip. Should be executed every time when mount point cell of
	 * this chip is read or written (but depends on trigger type).
	 * 
	 * @param mem memory which fires the chip
	 * @param offset mount point of the chip
	 * @param triggerType type of the trigger which was executed
	 */
	public void fire(Memory<T> mem, int offset, ChipTriggerType triggerType);
	/**
	 * Returns type of the trigger of this chip
	 * @return type of the trigger
	 */
	public ChipTriggerType getTriggerType();
}
