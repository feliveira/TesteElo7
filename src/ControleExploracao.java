import java.util.Scanner;

public class ControleExploracao {	
	
	Planalto planalto = new Planalto();
	Sonda sonda1 = new Sonda();
	Sonda sonda2 = new Sonda();
	
	Scanner sc = new Scanner(System.in);
	
	public void iniciarExploracao() {
		System.out.println("====== Sistema de Exploração Espacial ======"
				+ "\nÓtimo dia para descobrir os segredos do planeta vermelho, certo?"
				+ "\nMas antes precisaremos de alguns dados para prosseguirmos na missão:\n");
		
		do {
			System.out.println("Por favor, informe a dimensão da área que será explorada (X, Y)");
			System.out.print("Sua resposta: ");
			planalto.setTamanhoX(sc.nextInt());
			planalto.setTamanhoY(sc.nextInt());
			if(!planalto.ehValido()) {
				System.out.println("\nOps, alguma informação não foi inserida corretamente! Sem problemas, vamos tentar novamente?");
			}
		} while(!planalto.ehValido());


		do {
			System.out.println("\nPor favor, informe a coordenada da Sonda 1 que será lançada (X, Y, Direção)");
			System.out.print("Sua resposta: ");
			adicionarSonda(sonda1);
			if(!ehValidoCoordernadas(sonda1)) {
				System.out.println("\nOps, alguma informação não foi inserida corretamente! Sem problemas, vamos tentar novamente?");
			}
		}while(!ehValidoCoordernadas(sonda1));
		
		
		System.out.println("\nOk! Quase lá, por favor insira os comandos para a Sonda 1");

		do {
			System.out.print("Sua resposta: ");
			sonda1.setComandos(sc.next().toUpperCase());
			sonda1.ehValidoComandos();
			if(!sonda1.ehValidoComandos()) {
				System.out.println("\nOps, alguma informação não foi inserida corretamente! Sem problemas, vamos tentar novamente?");
				System.out.println("Por favor insira os comandos para a Sonda 1");
			}
		} while(!sonda1.ehValidoComandos());
		sonda1.executarComandos();
		
		
		do {
			System.out.println("\nPor favor, informe a coordenada da Sonda 2 que será lançada (X, Y, Direção)");
			System.out.print("Sua resposta: ");
			adicionarSonda(sonda2);
			if(!ehValidoCoordernadas(sonda2)) {
				System.out.println("\nOps, alguma informação não foi inserida corretamente! Sem problemas, vamos tentar novamente?");
			}
		}while(!ehValidoCoordernadas(sonda2));
		
		System.out.println("\nOk! Agora falta pouco, por favor insira os comandos para a Sonda 2");
		
		do {
			System.out.print("Sua resposta: ");
			sonda2.setComandos(sc.next().toUpperCase());
			sonda2.ehValidoComandos();
			if(!sonda2.ehValidoComandos()) {
				System.out.println("\nOps, alguma informação não foi inserida corretamente! Sem problemas, vamos tentar novamente?");
				System.out.println("Por favor insira os comandos para a Sonda 2");
			}
		} while(sonda2.ehValidoComandos() == false);
		sonda2.executarComandos();
		
		System.out.println("\n===========================================\n"
							+ "Sondas lançadas, a missão acaba de começar!"
							+"\n===========================================\n" );
		
		sc.close();
	}
	
	public void adicionarSonda(Sonda sonda) {
		sonda.setPosX(sc.nextInt());
		sonda.setPosY(sc.nextInt());
		sonda.setDirecao(sc.next().toUpperCase().charAt(0));
	}
	
	public boolean ehValidoCoordernadas(Sonda sonda) {
		boolean validade = true;
		if(sonda.getPosX() < 0 || sonda.getPosX() > planalto.getTamanhoX()) {
			validade = false;
		}
		else if(sonda.getPosY() < 0 || sonda.getPosY() > planalto.getTamanhoY()) {
			validade = false;
		}
		else if(sonda.getDirecao() != 'N' && sonda.getDirecao() != 'E' && sonda.getDirecao() != 'W' && sonda.getDirecao() != 'S') {
			validade = false;
		}
		return validade;
	}
	
	public void validarExploracao() {
		String coordenada1 ="" + sonda1.getPosX() + "" + sonda1.getPosY() + "";
		String coordenada2 ="" + sonda2.getPosX() + "" + sonda2.getPosY() + "";
		boolean primeirasondaestaperdida = false;
		boolean segundasondaestaperdida = false;
		
		if(coordenada1.equals(coordenada2)) {
			System.out.println("BOOM! As sondas colidiram, a missão falhou");
		}		
		
		if(sonda1.getPosX() < 0 || sonda1.getPosX() > planalto.getTamanhoX() || sonda1.getPosY() < 0 || sonda1.getPosY() > planalto.getTamanhoY()){
			System.out.println("Sonda 1 foi além dos limites previstos, contato perdido");
			primeirasondaestaperdida = true;
		}
		if(sonda2.getPosX() < 0 || sonda2.getPosX() > planalto.getTamanhoX() || sonda2.getPosY() < 0 || sonda2.getPosY() > planalto.getTamanhoY()) {
			System.out.println("Sonda 2 foi além dos limites previstos, contato perdido");
			segundasondaestaperdida = true;
		}
		
		if(primeirasondaestaperdida && segundasondaestaperdida) {
			System.out.println("Ambas as sondas foram além dos limites previstos, contato perdido, a missão fracassou");
		}
		else if(primeirasondaestaperdida || segundasondaestaperdida) {
			System.out.println("Conseguimos posicionar uma das duas sondas enviadas, missão sucedida");
		}
		
		if(coordenada1.equals(coordenada2) == false && primeirasondaestaperdida == false && segundasondaestaperdida == false) {
			System.out.println("Missão bem sucedida, ambas as sondas foram posicionadas corretamente, parabéns!");
		}
			
		System.out.println("\n===== Posições Finais das Sondas =====");
		System.out.println("Sonda1:\n- X: " + sonda1.getPosX() + " - Y: " + sonda1.getPosY() + " - Direção: " + sonda1.getDirecao());
		System.out.println("Sonda2:\n- X: " + sonda2.getPosX() + " - Y: " + sonda2.getPosY() + " - Direção: " + sonda2.getDirecao());
		
	}
}
