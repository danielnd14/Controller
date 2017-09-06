package com.zg

class Controller {
	private Portao portao

	Controller() {
		this.portao = new Portao()
	}

	private void abrir() {

		switch (portao.posicao) {
			case 0..3:
				portao.estado = Estado.ABRINDO
				portao.posicao++
				break
			case 4..5:
				portao.estado = Estado.ABERTO
				portao.posicao = 5
				break
			default: break
		}


	}

	private void fechar() {

		switch (portao.posicao) {
		// Não ficou claro o significado de cada valor deste inteiro posição,
		// Acredito que fique melhor substiuir o int por algo mais semântico
			case 5..2:
				portao.estado = Estado.FECHANDO
				portao.posicao--
				break
			case 1..0:
				portao.estado = Estado.FECHADO
				portao.posicao = 0
				break
			default: break
		}
	}

	String processar(String contexto) {

		StringBuilder saida = new StringBuilder()

		contexto.each {

			switch (it) {
				case 'P':
					moverPortao()
					break
				case 'O':
					alternarSentido()
					break
				case '.':
					manterEstado()
					break
				default: break
			}

			saida.append(portao.posicao)

		}


		reset()

		return saida
	}

	private void moverPortao() {


		if (portao.estado == Estado.FECHADO || portao.estado == Estado.PAUSADO_ABRINDO) {
			abrir()
		} else if (portao.estado == Estado.ABERTO || portao.estado == Estado.PAUSADO_FECHANDO) {
			fechar()
		} else if (portao.estado == Estado.ABRINDO || portao.estado == Estado.FECHANDO) {
			pausar()
		}

	}

	private void alternarSentido() {
		if (portao.estado == Estado.ABRINDO) {
			fechar()
		} else if (portao.estado == Estado.FECHANDO) {
			abrir()
		}
	}

	private void reset() {
		portao.estado = Estado.FECHADO
		portao.posicao = 0

	}

	private void manterEstado() {

		switch (portao.estado) {

			case Estado.ABERTO:
				portao.posicao = 5
				break
			case Estado.FECHADO:
				portao.posicao = 0
				break
			case Estado.ABRINDO:
				abrir()
				break
			case Estado.FECHANDO:
				fechar()
		}
	}

	private void pausar() {
		switch (portao.estado) {
			case Estado.ABRINDO: portao.estado = Estado.PAUSADO_ABRINDO
				break
			case Estado.FECHANDO: portao.estado = Estado.PAUSADO_FECHANDO
				break
			default: break
		}
	}
}
