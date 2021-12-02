import java.util.Scanner;

public class ControleExploracao {	
	
	Planalto planalto = new Planalto();
	Sonda sonda1 = new Sonda();
	Sonda sonda2 = new Sonda();
	
	Scanner sc = new Scanner(System.in);
	
	public void iniciarExploracao() {
		System.out.println("====== Sistema de Explora��o Espacial ======"
				+ "\n�timo dia para descobrir os segredos do planeta vermelho, certo?"
				+ "\nMas antes precisaremos de alguns dados para prosseguirmos na miss�o:\n");
		
		do {
			System.out.println("Por favor, informe a dimens�o da �rea que ser� explorada (X, Y)");
			System.out.print("Sua resposta: ");
			planalto.setTamanho(new Posicao(sc.nextInt(),sc.nextInt()));
			if(!planalto.ehValido()) {
				System.out.println("\nOps, alguma informa��o n�o foi inserida corretamente! Sem problemas, vamos tentar novamente?\n");
			}
		} while(!planalto.ehValido());
		
		
		boolean coordenadaAdicionada = false;
		while(!coordenadaAdicionada) {
			coordenadaAdicionada = adicionarCoordenada(sonda1, 1);
		}

		System.out.println("\nOk! Quase l�, por favor insira os comandos para a Sonda 1");

		adicionarComandos(sonda1);
		
		sonda1.executarComandos();
		
//		adicionarCoordenada(sonda2, 2);
//		
//		System.out.println("\nOk! Agora falta pouco, por favor insira os comandos para a Sonda 2");
//		
//		adicionarComandos(sonda2);
//		
//		sonda2.executarComandos();
		
		System.out.println("\n===========================================\n"
							+ "Sondas lan�adas, a miss�o acaba de come�ar!"
							+"\n===========================================\n" );
		
		sc.close();
	}
	
	public void adicionarSonda(Sonda sonda, int posX, int posY, Direcao direcao) {
		sonda.setPosicao(new Posicao(posX, posY));
		sonda.setDirecao(direcao);
	}
	
	
	public boolean adicionarCoordenada(Sonda sonda, int numeroSonda) {
			
			boolean ehValido = false;
			System.out.println("\nPor favor, informe a coordenada da Sonda " + numeroSonda + " que ser� lan�ada (X, Y, Dire��o)");
			System.out.print("Sua resposta: ");
			int posX = sc.nextInt();
			int posY = sc.nextInt();
			String direcao = sc.next();
			
			if(!ehValidoCoordernadas(posX, posY, direcao.toUpperCase())) {
				System.out.println("\nOps, alguma informa��o n�o foi inserida corretamente! Sem problemas, vamos tentar novamente?");
			}
			else {
				adicionarSonda(sonda, posX,posY,Direcao.valueOf(direcao.toUpperCase()));
				ehValido = true;
			}
			
			return ehValido;
	}
	
	
	public void adicionarComandos(Sonda sonda) {
		do {
			System.out.print("Sua resposta: ");
			sonda.setComandos(sc.next().toUpperCase());
			sonda.ehValidoComandos();
			if(!sonda.ehValidoComandos()) {
				System.out.println("\nOps, alguma informa��o n�o foi inserida corretamente! Sem problemas, vamos tentar novamente?");
				System.out.println("Por favor insira os comandos para a Sonda 1");
			}
		} while(!sonda.ehValidoComandos());
	}
	
	
	public boolean ehValidoCoordernadas(int posX, int posY, String direcao) {
		boolean ehvalidoPosicao = true;
		if(posX < 0 || posX > planalto.getTamanho().getX()) {
			ehvalidoPosicao = false;
		}
		else if(posY < 0 || posY > planalto.getTamanho().getY()) {
			ehvalidoPosicao = false;
		}
		
		Direcao[] direcoes = Direcao.values();
		
		boolean ehValidoDirecao = false;
		for(Direcao d: direcoes) {
			if(d.getValor().equals(direcao)) {
				ehValidoDirecao = true;
			}
		}
		return ehvalidoPosicao && ehValidoDirecao;
	}
	
	
	public void validarExploracao() {
//		String coordenada1 ="" + sonda1.getPosicao().getX() + "" + sonda1.getPosicao().getY() + "";
//		//String coordenada2 ="" + sonda2.getPosicao().getX() + "" + sonda2.getPosicao().getY() + "";
//		boolean primeirasondaestaperdida = false;
//		boolean segundasondaestaperdida = false;
		
//		if(coordenada1.equals(coordenada2)) {
//			System.out.println("BOOM! As sondas colidiram, a miss�o falhou");
//		}		
		
		if(sonda1.getPosicao().getX() < 0 || sonda1.getPosicao().getX() > planalto.getTamanho().getX() || sonda1.getPosicao().getY() < 0 ||sonda1.getPosicao().getY() > planalto.getTamanho().getY()){
			System.out.println("Sonda 1 foi al�m dos limites previstos, contato perdido");
//			primeirasondaestaperdida = true;
		}
//		if(sonda2.getPosicao().getX() < 0 || sonda2.getPosicao().getX() > planalto.getTamanhoX() ||sonda2.getPosicao().getY() < 0 || sonda2.getPosicao().getY() > planalto.getTamanhoY()) {
//			System.out.println("Sonda 2 foi al�m dos limites previstos, contato perdido");
//			segundasondaestaperdida = true;
//		}
		
//		if(primeirasondaestaperdida && segundasondaestaperdida) {
//			System.out.println("Ambas as sondas foram al�m dos limites previstos, contato perdido, a miss�o fracassou");
//		}
//		else if(primeirasondaestaperdida || segundasondaestaperdida) {
//			System.out.println("Conseguimos posicionar uma das duas sondas enviadas, miss�o sucedida");
//		}
		
//		if(coordenada1.equals(coordenada2) == false && primeirasondaestaperdida == false && segundasondaestaperdida == false) {
//			System.out.println("Miss�o bem sucedida, ambas as sondas foram posicionadas corretamente, parab�ns!");
//		}
			
		System.out.println("\n===== Posi��es Finais das Sondas =====");
		System.out.println("Sonda1:\n- X: " + sonda1.getPosicao().getX() + " - Y: " + sonda1.getPosicao().getY() + " - Dire��o: " + sonda1.getDirecao());
//		System.out.println("Sonda2:\n- X: " + sonda2.getPosicao().getX() + " - Y: " + sonda1.getPosicao().getY() + " - Dire��o: " + sonda2.getDirecao());
		
	}
}
