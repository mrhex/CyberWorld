package ua.kiev.cyberworld.computer.intbased.chips;

import java.util.Random;

import ua.kiev.cyberworld.computer.Chip;
import ua.kiev.cyberworld.computer.ChipTriggerType;
import ua.kiev.cyberworld.computer.Memory;

/**
 * <code>Integer</code> based generator of random values. When mount point cell
 * is written then it sets to the mount point cell random value from 0 to
 * written value. When mount point cell is read and previously it was written it
 * return value of the cell. When mount point cell is read but was not written
 * before it returns random value.
 */
public class IntChipRandomizer implements Chip<Integer> {

	private Random rnd = new Random();
	private ChipTriggerType triggerStatus = ChipTriggerType.BOTH;
	/**
	 * A "wait for a read" flag defines behavior for the read operation
	 */
	private boolean waitForTheRead = false;

	@Override
	public void fire(Memory<Integer> mem, int offset,
			ChipTriggerType triggerType) {

		// if cell is written
		// then generates random int from 0 to written value and sets
		// "wait for the read" flag on
		if (triggerType == ChipTriggerType.WRITE) {
			triggerStatus = ChipTriggerType.NONE; // disable trigger to avoid
													// infinitive loop
			mem.set(offset, rnd.nextInt(mem.get(offset))); // generate random
															// value from 0 to
															// specified to the
															// mout point cell
															// value
			waitForTheRead = true; // now we are waiting for a read of generated
									// value
			triggerStatus = ChipTriggerType.BOTH; // enable trigger back

			// if cell is read
		} else if (triggerType == ChipTriggerType.READ) {
			// if cell was written before
			// then just returns prepared value and "wait for the read" flag off
			if (waitForTheRead) {
				waitForTheRead = false; // it was read once, so we don't wait
										// for read operation anymore

				// if cell wasn't written before
				// then generates and return random int value
			} else {
				triggerStatus = ChipTriggerType.NONE; // disable trigger to
														// avoid infinitive loop
				mem.set(offset, rnd.nextInt()); // generate random value
				triggerStatus = ChipTriggerType.BOTH; // enable trigger back
			}
		} else {
			// unreachable code
			assert false : "Illegal trigger type";
		}
	}

	@Override
	public ChipTriggerType getTriggerType() {
		return triggerStatus;
	}

}
