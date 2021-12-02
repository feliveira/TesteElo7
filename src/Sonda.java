
public class Sonda {
	
	private int posX;
	private int posY;
	private Direcao direcao;
	private String comandos;
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
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
			posY += 1;
		}
		else if(direcao == Direcao.E) {
			posX += 1;
		}
		else if(direcao == Direcao.S) {
			posY -= 1;
		}
		else {
			posX -= 1;
		}
	}
	
	public void executarComandos() {
		this.comandos = this.comandos.toUpperCase();
		for(int i = 0; i < comandos.length(); i++) {
			if(comandos.charAt(i) == 'R' || comandos.charAt(i) == 'L' ) {
				virar(comandos.charAt(i));
			}
			else if(comandos.charAt(i) == 'M'){
				mover();
			}
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
