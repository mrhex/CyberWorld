package ua.kiev.cyberworld;


import java.awt.Point;

import ua.kiev.cyberworld.computer.intbased.IntComputerI1;
import ua.kiev.cyberworld.computer.intbased.IntMemory;
import ua.kiev.cyberworld.computer.intbased.chips.IntChipRandomizer;
import ua.kiev.cyberworld.field.Action;
import ua.kiev.cyberworld.field.ActionMoveLeft;
import ua.kiev.cyberworld.field.Field;
import ua.kiev.cyberworld.field.HashMapField;
import ua.kiev.cyberworld.field.Wall;

public class Run {

	public static void main(String[] args) {
		
		Field f = new HashMapField();
		Wall w = new Wall();
		Object o = new Object();
		f.setObject(o, new Point(0,0));
		f.setObject(w, new Point(0,2));
		Action a = new ActionMoveLeft();
		
		System.out.println(f.getPoint(o));
		a.perform(f, o, null);
		System.out.println(f.getPoint(o));
		a.perform(f, o, null);
		System.out.println(f.getPoint(o));
		a.perform(f, o, null);
		System.out.println(f.getPoint(o));
		a.perform(f, o, null);
		/*
		
		// primitive comp demo
		
		IntMemory mem = new IntMemory(13); // creates new memory
		mem.set(0, 4);	// #0  first instruction is in cell #4
		//mem.set(1,0); // #1  this cell is registered as register A
		mem.set(2, 5);  // #2  Randomizer mount point
		mem.set(3, 9);  // #3  constant
		mem.set(4, 1);  // #4  GET instruction
		mem.set(5, 3);  // #5  GET arg. get from #3 (constant=9)
		mem.set(6, 2);  // #6  SET instruction
		mem.set(7, 2);  // #7  SET arg. to #2 (write to randomizer)
		mem.set(8, 1);  // #8  GET instruction
		mem.set(9, 2);  // #9  GET from randomizer
		mem.set(10, 1); // #10 GET instruction
		mem.set(11, 2); // #11 GET from randomizer again
		mem.addDevice(2, new IntChipRandomizer()); // mount randomizer to cell #2
		IntComputerI1 c = new IntComputerI1(mem); // creates new computer
		// run computer till it have something to execute
		while(c.tick()){
		}
		*/
		
	}

}
