
public class Sonda {
	
	private int posX;
	private int posY;
	private char direcao;
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
	public char getDirecao() {
		return direcao;
	}
	public void setDirecao(char direcao) {
		this.direcao = direcao;
	}
	public String getComandos() {
		return comandos;
	}

	public void setComandos(String comandos) {
		this.comandos = comandos;
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
	
	public void mover() {
		if(direcao == 'N') {
			posY += 1;
		}
		else if(direcao == 'E') {
			posX += 1;
		}
		else if(direcao == 'S') {
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
