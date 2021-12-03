
public class Sonda {
	
	private Posicao posicao;
	private Direcao direcao;
	private String comandos;
	
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	
	public Posicao getPosicao() {
		return posicao;
	}
	
	public Direcao getDirecao() {
		return direcao;
	}
	public void setDirecao(Direcao d) {
		this.direcao = d;
	}
	public String getComandos() {
		return comandos;
	}

	public void setComandos(String comandos) {
		this.comandos = comandos;
	}
	
	public void virar(char comando) {
		if(comando == 'R') {
				switch(direcao) {
				case N:
					direcao = Direcao.E;
					break;
				case E:
					direcao = Direcao.S;
					break;
				case S:
					direcao = Direcao.W;
					break;
				case W:
					direcao = Direcao.N;
					break;
			}
		}
		else {
			switch(direcao) {
			 	case N:
			 		direcao = Direcao.W;
			 		break;
			 	case W:
			 		direcao = Direcao.S;
			 		break;
			 	case S:
			 		direcao = Direcao.E;
			 		break;
			 	case E:
			 		direcao = Direcao.N;
			 		break;
			}
		}
	}
	
	public void mover() {
		if(direcao == Direcao.N) {
			posicao.setY(posicao.getY() + 1);
		}
		else if(direcao == Direcao.E) {
			posicao.setX(posicao.getX() + 1);
		}
		else if(direcao == Direcao.S) {
			posicao.setY(posicao.getY() - 1);
		}
		else {
			posicao.setX(posicao.getX() - 1);
		}
	}
	
	public void executarComando(char comando) {
		if(comando == 'R' || comando == 'L') {
			virar(comando);
		}
		else if(comando == 'M'){
			mover();
		}
	}
	
	public boolean ehValidoComandos() {
		boolean validade = true;
		for(int i = 0; i < comandos.length(); i++) {
			if(comandos.charAt(i) != 'R' && comandos.charAt(i) != 'L' && comandos.charAt(i) != 'M') {
				validade = false;
				return validade;
			}
			
		}
		return validade;
	}
	
}
