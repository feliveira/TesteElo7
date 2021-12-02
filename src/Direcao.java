
public enum Direcao {
	N("N"), E("E"), S("S"), W("W");
	
	private String valor;
	
	Direcao(String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
	
}
