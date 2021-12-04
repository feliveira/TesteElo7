import java.util.Objects;
import java.util.Scanner;

public class ControleExploracao {	
	
	Planalto planalto = new Planalto();
	Sonda[] listaSondas;
	int qtdColisoes = 0;
	
	Scanner sc = new Scanner(System.in);
	
	public void iniciarExploracao() {
		System.out.println("====== Sistema de Exploração Espacial ======"
				+ "\nÓtimo dia para descobrir os segredos do planeta vermelho, certo?"
				+ "\nMas antes precisaremos de alguns dados para prosseguirmos na missão:\n");
		
		do {
			System.out.println("Por favor, informe a dimensão da área que será explorada (X, Y)");
			System.out.print("Sua resposta: ");
			planalto.setTamanho(new Posicao(sc.nextInt(),sc.nextInt()));
			if(!planalto.ehValido()) {
				System.out.println("\nOps, alguma informação não foi inserida corretamente! Sem problemas, vamos tentar novamente?\n");
			}
		} while(!planalto.ehValido());
		
		System.out.println("\nObrigado! Agora, por favor, nos diga quantas sondas serão enviadas para a missão de hoje: ");
		int qtdSondas = 0;
		do {
			System.out.print("Sua resposta: ");
			qtdSondas = sc.nextInt();
			if(qtdSondas <= 0) {
				System.out.println("\nPor favor, informe um número válido de sondas: ");
			}
		} while(qtdSondas <= 0);
		
		listaSondas = new Sonda[qtdSondas];
		
		
		for(int i = 0; i < listaSondas.length; i++) {
				System.out.println("\nPor favor, informe a coordenada da Sonda " + (i + 1) + " que será lançada (X, Y, Direção)");
				listaSondas[i] = AdicionarSondas(i);
		}
				
		for(int i = 0; i < listaSondas.length; i++) {
			String comandos = listaSondas[i].getComandos();
			for(int j = 0; j < comandos.length(); j++) {
				listaSondas[i].executarComando(comandos.charAt(j));
				if(i >= 1) {
					if(existeColisao(listaSondas[i].getPosicao().getX(),listaSondas[i].getPosicao().getY(), i)) {
						comandos = "";
						qtdColisoes++;
					}
				}
				
			}
			
		}
		
		System.out.println("\n===========================================\n"
							+ "Sondas lançadas, a missão acaba de começar!"
							+"\n===========================================\n" );
		
		sc.close();
	}
	
	public boolean existeColisao(int posX, int posY, int numeroSonda) {
		boolean existeColisao = false;
		for(int i = 0; i < listaSondas.length; i++) {
			if(Objects.nonNull(listaSondas[i])) {
				if(i != numeroSonda && listaSondas[i].getPosicao().getX() == posX && listaSondas[i].getPosicao().getY() == posY) {
					existeColisao = true;
				}
			}
		}
		
		return existeColisao;
	}
	
	public Sonda AdicionarSondas(int numeroSonda) {
		Sonda sonda = new Sonda();
		int posX = 0, posY = 0;
		String direcao = "";
		
		boolean haColisao = false;
		do {
			System.out.print("Sua resposta: ");
			posX = sc.nextInt();
			posY = sc.nextInt();
			direcao = sc.next();
			if(!ehValidoCoordernadas(posX, posY,direcao)) {
				System.out.println("\nOps, alguma informação não foi inserida corretamente! Sem problemas, vamos tentar novamente?");
				System.out.println("\nPor favor, informe a coordenada da Sonda " + (numeroSonda + 1) + " que será lançada (X, Y, Direção)");
			}
			else if(numeroSonda >= 1) {
				haColisao = existeColisao(posX, posY, numeroSonda);
				if(haColisao) {
					System.out.println("\nOps, a coordenada informada ocasionará em Colisão, vamos tentar novamente?");
					System.out.println("\nPor favor, informe a coordenada da Sonda " + (numeroSonda + 1) + " que será lançada (X, Y, Direção)");
					
				}
			}
		}while(!ehValidoCoordernadas(posX, posY,direcao) || haColisao);
		
		adicionarSonda(sonda, posX,posY,Direcao.valueOf(direcao.toUpperCase()));
		
		adicionarComandos(sonda,numeroSonda);
		
		return sonda;
		
	}
	
	public void adicionarSonda(Sonda sonda, int posX, int posY, Direcao direcao) {
		sonda.setPosicao(new Posicao(posX, posY));
		sonda.setDirecao(direcao);
	}
	
	public void adicionarComandos(Sonda sonda,int numeroSonda) {
		System.out.println("\nOk! Por favor insira os comandos para a Sonda " + (numeroSonda + 1) );
		do {
			System.out.print("Sua resposta: ");
			sonda.setComandos(sc.next().toUpperCase());
			sonda.ehValidoComandos();
			if(!sonda.ehValidoComandos()) {
				System.out.println("\nOps, alguma informação não foi inserida corretamente! Sem problemas, vamos tentar novamente?");
				System.out.println("Por favor insira os comandos para a Sonda "+ (numeroSonda + 1) + " :");
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
			if(d.getValor().equalsIgnoreCase(direcao)) {
				ehValidoDirecao = true;
			}
		}
		
		
		return ehvalidoPosicao && ehValidoDirecao;
	}
	
	public int verificarSondasPosicionadas() {
		int qtdSondasPosicionadas = 0;
		String numeroSondasPosicionadas = "";
		String numeroSondasForaLimites = "";
		String numeroSondasColidiram = "";
		
		for(int i = 0; i < listaSondas.length; i++) {
			boolean temColisao = existeColisao(listaSondas[i].getPosicao().getX(), listaSondas[i].getPosicao().getY(), i);
			boolean passouLimite = passouLimites(listaSondas[i].getPosicao().getX(), listaSondas[i].getPosicao().getY());
			if(!temColisao && !passouLimite) {
				qtdSondasPosicionadas++;
				numeroSondasPosicionadas+= " Sonda " + (i+1) + ",";
			}
			
			if(passouLimite) {
				numeroSondasForaLimites += " Sonda " + (i+1) + ",";
			}
			
			if(temColisao) {
				numeroSondasColidiram += " Sonda " + (i+1) + ",";
			}
		}
		
		if(numeroSondasColidiram.length() > 0) {
			System.out.println("Sondas que colidiram:" + numeroSondasColidiram);
		}
		else {
			System.out.println("Sondas que colidiram: nenhuma,");
		}
		
		
		System.out.printf("Quantidade de Sondas posicionadas corretamente: %d,", qtdSondasPosicionadas);
		
		if(numeroSondasPosicionadas.length() > 0) {
			System.out.println("\nSondas posicionadas corretamente:" + numeroSondasPosicionadas );
		}
		else {
			System.out.println("\nSondas posicionadas corretamente: nenhuma,");
		}
		
		if(numeroSondasForaLimites.length() > 0) {
			System.out.println("Sondas que perdemos contato (foram além do Planalto):" + numeroSondasForaLimites);
		}
		else {
			System.out.println("Sondas que perdemos contato (foram além do Planalto): nenhuma,");
		}
		
		return qtdSondasPosicionadas;
		
	}
	
	public boolean passouLimites(int posX, int posY) {
		boolean passouLimites = false;
		if(posX > planalto.getTamanho().getX() || posY > planalto.getTamanho().getY()) {
			passouLimites = true;
		}
		else if(posX < 0 || posY < 0) {
			passouLimites = true;
		}
		
		return passouLimites;
	}
	
	public void validarExploracao() {
		
		System.out.println("Resumo da Missão: ");
		
		System.out.printf("\nQuantidade de Colisões: %s,\n",qtdColisoes);
		
		int qtdSondasPosicionadas = verificarSondasPosicionadas();
		int sondasAdicionadas = listaSondas.length;
		String resultadoExploracao = "";
		String proporcaoAcertos =  qtdSondasPosicionadas  +  " / "  + sondasAdicionadas;
		
		
		if(qtdSondasPosicionadas == sondasAdicionadas) {
			resultadoExploracao = proporcaoAcertos + " - Todas as " + sondasAdicionadas + " sondas foram posicionadas corretamente, a missão foi um completo sucesso!";
		}
		else if(qtdSondasPosicionadas > (sondasAdicionadas * 0.5)) {
			resultadoExploracao = proporcaoAcertos + " - A maior parte das "+ sondasAdicionadas + " sondas foram posicionadas corretamente, a missão foi um sucesso!";
		}
		else if(qtdSondasPosicionadas > 0) {
			resultadoExploracao = proporcaoAcertos + " - Conseguimos posicionar " + qtdSondasPosicionadas + " sondas, poderia ser melhor, mas não deixa de ser um êxito!";
		}
		else if(sondasAdicionadas == 1){
			resultadoExploracao = "Não conseguimos posicionar nenhuma sonda, a missão fracassou...";
			
		}
		else {
			resultadoExploracao = "Não conseguimos posicionar nenhuma das "+ sondasAdicionadas +" sondas, a missão fracassou...";
		}
		
		System.out.println("\nResultado Final: " + resultadoExploracao);
	
		System.out.println("\n===== Posições Finais das Sondas =====");
		for(int i = 0; i < listaSondas.length; i++) {
			System.out.println("Sonda "+ (i+1) + ":\n- X: " + listaSondas[i].getPosicao().getX() + " - Y: " + listaSondas[i].getPosicao().getY() + " - Direção: " + listaSondas[i].getDirecao());
		}		
		
	}
}
