
public class Testes {

	public static void main(String[] args)  {
		boolean ehValidoDirecao = false;
		Direcao[] direcoes = Direcao.values();
		
		String direcao = "s".toUpperCase();
		
		for(Direcao d: direcoes) {
			if(d.getValor().equals(direcao)) {
				ehValidoDirecao = true;
			}
		}
		
		System.out.println(ehValidoDirecao);
	}

}
