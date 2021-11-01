
public class Planalto {
	
	private int tamanhoX;
	private int tamanhoY;
	
	public int getTamanhoX() {
		return tamanhoX;
	}
	public void setTamanhoX(int tamanhoX) {
		this.tamanhoX = tamanhoX;
	}
	public int getTamanhoY() {
		return tamanhoY;
	}
	public void setTamanhoY(int tamanhoY) {
		this.tamanhoY = tamanhoY;
	}
	
	public boolean ehValido() {
		boolean ehValido = false;
		if(this.tamanhoX > 0 && this.tamanhoY > 0) {
			ehValido = true;
		}
		
		return ehValido;
	}
	
}
