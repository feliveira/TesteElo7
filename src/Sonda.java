
public class Sonda {
	
	private int posX;
	private int posY;
	private char direcao;
	
	
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
	public char getDirecao() {
		return direcao;
	}
	public void setDirecao(char direcao) {
		this.direcao = direcao;
	}
	
	
	public void virar(char comando) {
		String direcoes = "NESW";
		
		if(comando == 'R') {
			if(direcao == 'W') {
				direcao = 'N';
			}
			else {
				direcao = direcoes.charAt(direcoes.indexOf(direcao) + 1);
			}
			
		}
		else {
			if(direcao == 'N') {
				direcao = 'W';
			}
			else {
				direcao = direcoes.charAt(direcoes.indexOf(direcao) - 1);
			}
		}
	}
	
}
