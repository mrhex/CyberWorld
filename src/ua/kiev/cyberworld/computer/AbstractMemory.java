package ua.kiev.cyberworld.computer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ArrayList based memory
 * 
 * @param <T> type of the memory cell
 */
public abstract class AbstractMemory<T> implements Memory<T> {
	protected List<T> mem;
	private Map<Integer, Chip<T>> dev = new HashMap<Integer, Chip<T>>();

	/**
	 * Constructs new memory with specific size
	 * @param size number of memory cells
	 */
	public AbstractMemory(int size) {
		mem = new ArrayList<T>(size);
	}

	@Override
	public void set(int addr, T val) {
		mem.set(addr, val);
		if (dev.containsKey(addr)
				&& (dev.get(addr).getTriggerType() == ChipTriggerType.WRITE
				|| dev.get(addr).getTriggerType() == ChipTriggerType.BOTH)) {
			dev.get(addr).fire(this,addr,ChipTriggerType.WRITE);
		}
	}

	@Override
	public T get(int addr) {
		if (dev.containsKey(addr)
				&& (dev.get(addr).getTriggerType() == ChipTriggerType.READ
				|| dev.get(addr).getTriggerType() == ChipTriggerType.BOTH)) {
			dev.get(addr).fire(this,addr,ChipTriggerType.READ);
		}		
		return mem.get(addr);
	}

	@Override
	public void addDevice(int addr, Chip<T> dev) {
		this.dev.put(addr, dev);
	}

	@Override
	public String toString() {
		return mem.toString();
	}

	
}
