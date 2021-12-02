
public class Planalto {
	
	private Posicao tamanho;
	
	public Posicao getTamanho() {
		return tamanho;
	}
	public void setTamanho(Posicao tamanho) {
		this.tamanho = tamanho;
	}
	
	public boolean ehValido() {
		boolean ehValido = false;
		if(this.tamanho.getX() > 0 && this.tamanho.getY() > 0) {
			ehValido = true;
		}
		
		return ehValido;
	}
	
}
