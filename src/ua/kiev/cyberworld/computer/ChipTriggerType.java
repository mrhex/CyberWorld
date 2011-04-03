package ua.kiev.cyberworld.computer;
/**
 * Enumeration of the available triggers
 * <code>NONE</code> - ignore all events
 * <code>READ</code> - happens when memory cell is read
 * <code>WRITE</code> - happens when memory cell is changed
 * <code>BOTH</code> - happens when memory cell is read or changes
 * @author lk
 *
 */
public enum ChipTriggerType {
	NONE,
	READ, 
	WRITE, 
	BOTH
}
