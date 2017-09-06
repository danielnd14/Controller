package com.zg

class Main {

	static void main(String[] args) {

		String[] entradas = new String[7]
		entradas[0] = "..P...O....."    //001234321000
		entradas[1] = ".P...."            //012345
		entradas[2] = "...P.P...P.."    //000122222345
		entradas[3] = "P..O.."            //123210
		entradas[4] = "P..P...PO..."    //123333343210
		entradas[5] = "P...O.O.P...P.."    //123432344444555
		entradas[6] = "P...O.O.PPPPP"    //123432344444555

		Controller controle = new Controller()

		for (String entrada in entradas) {
			println(controle.processar(entrada))
		}


	}
}
