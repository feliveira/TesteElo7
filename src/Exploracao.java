//import java.util.Scanner;

public class Exploracao {
	
	public static void main(String[] args) {
		Sonda sonda = new Sonda(3,3,'E');
		
		String direcoes = "MMRMMRMRRM";
		
		for(int i = 0; i < direcoes.length(); i++) {
			if(direcoes.charAt(i) == 'R' || direcoes.charAt(i) == 'L' ) {
				sonda.virar(direcoes.charAt(i));
			}
			else{
				sonda.mover();
			}
		}
		
		System.out.println(sonda.getPosX() + " " + sonda.getPosY() + " " + sonda.getDirecao());
		
		
		
	}
	
	
	
}
