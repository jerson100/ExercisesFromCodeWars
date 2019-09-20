package CuatroKyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConectarCuatro {

	public static void main(String[] args) {

		// a = 97 - 97
		// A = 65 - 65 para que haga referencia a la columna 1
		String [][]m = new String[][] {
			{"","","","","","",""},
			{"","","","","","",""},
			{"","","","y","","",""},
			{"","","","","y","",""},
			{"","","","","","y",""},
			{"","","","","","","y"}
		};
		
		System.out.println(ganador(m, 3, 4, "y"));
		
		List<String> myList = new ArrayList<String>(Arrays.asList(
				"C_Yellow", "E_Red", "G_Yellow", "B_Red", "D_Yellow", "B_Red",
				"B_Yellow", "G_Red", "C_Yellow", "C_Red", "D_Yellow", "F_Red",
				"E_Yellow", "A_Red", "A_Yellow", "G_Red", "A_Yellow", "F_Red",
				"F_Yellow", "D_Red", "B_Yellow", "E_Red", "D_Yellow", "A_Red",
				"G_Yellow", "D_Red", "D_Yellow", "C_Red"
	        ));
		
		System.out.println(whoIsWinner(myList));
	}


	public static String ganador(String[][] m,int f,int c,String color) {
		
		//horizontal
		int cc = 0;
		for (int i = c; i < c+4; i++) {
			if(i<0 || i>=m[f].length || m[f][i]==null || !m[f][i].equals(color))break;
			cc++;
		}
		if(cc==4)return color;
		cc--;
		for (int i = c; i>c-4; i--) {
			if(i<0 || i>=m[f].length || m[f][i]==null||!m[f][i].equals(color))break;
			cc++;
		}
		if(cc>=4)return color;
		
		//vertical
		cc=0;
		for (int i = f; i < f+4; i++) {
			if(i<0 || i>=m.length || m[i][c]==null||!m[i][c].equals(color))break;
			cc++;
		}
		if(cc==4)return color;
		cc--;
		for (int i = f; i>f-4; i--) {
			if(i<0 || i>=m.length || m[i][c]==null||!m[i][c].equals(color))break;
			cc++;
		}
		if(cc>=4)return color;
		
		//diagonal derecha a izquierda
		cc=0;
		for (int i = f; i < f+4; i++) {
			if(i<0 || i>=m.length || c+i-f<0 || c+i-f>=m[i].length 
					|| m[i][c+i-f]==null||!m[i][c+i-f].equals(color))break;
			cc++;
		}
		if(cc==4)return color;
		cc--;
		for (int i = f; i>f-4; i--) {
			if(i<0 || i>=m.length || c-(f-i)<0 || c-(f-i)>=m[i].length 
					|| m[i][c-(f-i)]==null||!m[i][c-(f-i)].equals(color))break;
			cc++;
		}
		if(cc>=4)return color;
		
		//diagonal derecha a izquierda
		cc=0;
		for (int i = f; i < f+4; i++) {
			if(i<0 || i>=m.length || c-(i-f)<0  || c-(i-f)>=m[i].length 
					|| m[i][c-(i-f)]==null||!m[i][c-(i-f)].equals(color))break;
			cc++;
		}
		if(cc==4)return color;
		cc--;
		
		for (int i = f; i>f-4; i--) {
			if(i<0 || i>=m.length || c+(f-i)<0 || c+(f-i)>=m[i].length
					||m[i][c+(f-i)]==null||!m[i][c+(f-i)].equals(color))break;
			cc++;
		}
		if(cc>=4)return color;
		
		return null;
	}
	
	public static String whoIsWinner(List<String> piecesPositionList) {
		String letra,color,rspt;
		String [][] matriz = new String[6][7];
		String dat[];
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0,ff,cc,fil=0;
		for (int i = 0; i < piecesPositionList.size(); i++) {
			dat = piecesPositionList.get(i).split("_");
			letra = dat[0];
			color = dat[1];
			switch (letra) {
			case "A":fil = a;a++;break;
			case "B":fil = b;b++;break;
			case "C":fil = c;c++;break;
			case "D":fil = d;d++;break;
			case "E":fil = e;e++;break;
			case "F":fil = f;f++;break;
			case "G":fil = g;g++;break;
			default:fil=0;
			}
			ff = matriz.length-fil-1;
			cc = ((int)letra.charAt(0))-65;
			matriz[ff][cc] = color;
			rspt = ganador(matriz, ff, cc, color);
			if(rspt!=null) {
				return rspt;
			}	
		}
		return "Draw";
	}

}
