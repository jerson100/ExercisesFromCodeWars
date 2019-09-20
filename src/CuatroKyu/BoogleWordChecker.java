package CuatroKyu;

import java.util.Scanner;

public class BoogleWordChecker {
	
	private char[][]board;
	private String word; 
	
	public BoogleWordChecker(char [][]board,String word) {
		this.board = board;
		this.word = word;
	}

	public boolean check(){
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(word.charAt(0)==board[i][j]) {
					if(checker(word, board, "", i, j)) {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	private static boolean checker(String c,char m[][],
								   String aux,
								   int i,int j) {
		
		//System.out.println(aux);

		if(!c.startsWith(aux)) return false;
		
		if(aux.length()==c.length() && c.equals(aux)) {
			return true;
		}else if(aux.length()==c.length() && !c.equals(aux)) {
			return false;
		}
		
		if(i<0 || i>m.length-1 || j<0 || j>m[i].length-1) {
			return false;
		}
		
		if(m[i][j]=='+')return false;
		
		char sd = m[i][j];
		//el + es para saber si ya pasó por ese lugar
		m[i][j] = '+';
		
		//vertical
		boolean opc = checker(c, m, aux + sd, i-1, j);	
		if(opc)return true;
		
		opc = checker(c, m, aux + sd, i+1, j);
		if(opc)return true;

		//horizontal
		opc = checker(c, m, aux + sd, i, j+1);
		if(opc)return true;
		
		opc = checker(c, m, aux + sd, i, j-1);
		if(opc)return true;
		
		//diagonales
		opc = checker(c, m, aux + sd, i+1, j+1);
		if(opc)return true;
		
		opc = checker(c, m, aux + sd, i-1, j-1);		
		if(opc)return true;
		
		opc = checker(c, m, aux + sd, i+1, j-1);				
		if(opc)return true;
		
		opc = checker(c, m, aux + sd, i-1, j+1);
		
		if(opc) {
			return true;
		}else {
			m[i][j] = sd;
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		boolean opc=false;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Probando el algoritmo------ ");
			
			
			System.out.print("Ingrese la palabra a buscar: ");
			
			String palabra = sc.nextLine();
			
			System.out.println("\nBuscando la palabra: "+palabra);
			
			char m[][] = {
					{'E','A','R','A'},
			        {'N','L','E','C'},
			        {'I','A','I','S'},
			        {'B','Y','O','R'},
			        {'P','E','L','E'},
			        {'R','A','O','C'},
			        {'U','S','N','A'}
			};
			
			for (char[] cs : m) {
				for (char c : cs) {
					System.out.print(c+"\t");
				}
				System.out.println();
			}
			
			BoogleWordChecker b = new BoogleWordChecker(m, palabra);
			
			if(b.check()) {
				System.out.println("Se encontró la palabra "+palabra);
			}else {
				System.out.println("No se encontró la palabra "+palabra);
			}
			
			System.out.println("Desea continuar buscando palabras? S/N");
			opc = sc.nextLine().equals("S")?true:false;
			System.out.println("----------------------------");
		
		}while(opc);
		
		
		sc.close();
		
		//System.out.println(checker("CEREAL", m, "", 3, 3));
		
	}	
	
}
