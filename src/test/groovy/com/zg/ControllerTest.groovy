package com.zg

class ControllerTest extends GroovyTestCase {
	Controller control = new Controller()
	void testProcessar1() {
		assert ("001234321000"==control.processar("..P...O....."))
	}
	void testProcessar2(){
		assert ("012345"==control.processar(".P...."))
	}
	void testProcessar3(){
		assert ("000122222345"==control.processar("...P.P...P.."))
	}
	void testProcessar4(){
		assert ("123210"==control.processar("P..O.."))
	}
	void testProcessar5(){
		assert ("123333343210"==control.processar("P..P...PO..."))
	}
	void testProcessar6(){
		assert ("123432344444555"==control.processar("P...O.O.P...P.."))
	}
	void testProcessar7(){
		assert ("1234323445443"==control.processar("P...O.O.PPPPP"))
	}

}
