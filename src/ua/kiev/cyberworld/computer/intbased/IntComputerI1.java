package ua.kiev.cyberworld.computer.intbased;


import ua.kiev.cyberworld.computer.AbstractComputer;
import ua.kiev.cyberworld.computer.Memory;

/**
 * Simplest integer-based implementation of the <code>Computer</code> interface.
 * This computer provides only two instructions SET and GET. And have two registred memory cells:
 * 0 - next instruction address
 * 1 - register A
 * @author lk
 *
 */
public class IntComputerI1 extends AbstractComputer<Integer> {

	public IntComputerI1(Memory<Integer> memory) {
		super(memory);
	}

	@Override
	public boolean tick() {
		switch(next()) {
		case 1:   // GET
			cmdGet(next());
			break;
		case 2:   // SET
			cmdSet(next());
			break;
		default:
				return false;
		}
		return true;
	}

	/**
	 * Returns next instruction and increase address of the next instruction by one
	 * @return next instruction
	 */
	private int next() {
		System.out.println(mem.toString()); // print memory state (for debug)
		mem.set(0, mem.get(0)+1);
		return mem.get(mem.get(0)-1);
	}
	
	/**
	 * Gets value of specific memory cell and puts it into the register A (cell #1)
	 * @param addr index of the cell to read from
	 */
	private void cmdGet(int addr) {
		mem.set(1, mem.get(addr));
	}
	
	/**
	 * Gets value from the register A (cell #1) and puts it into the specific cell
	 * @param addr index of the cell to write to
	 */
	private void cmdSet(int addr) {
		mem.set(addr, mem.get(1));
	}
}
