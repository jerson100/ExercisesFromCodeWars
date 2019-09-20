package CuatroKyu;

public class Laberinto {

	public static void main(String[] args) {
		
		System.out.println(hasExit(new String[] {
				"###########",
				"#k        #",
				"#########"}));
		
	}
	
	public static boolean hasExit(String []maze) {
		String mazee[][] = new String[maze.length][maze[0].length()];
		int partida[] = new int[2];
		for (int i = 0; i < mazee.length; i++) {
			for (int j = 0; j < mazee[0].length; j++) {
				if(j>=maze[i].length()) {
					mazee[i][j] = " ";
				}else {
					mazee[i][j] = maze[i].charAt(j)+"";
					if(mazee[i][j].toLowerCase().equals("k")) {
						partida[0] = i;partida[1] = j;
					}
				}
			}
		}
		return escapar(mazee,partida[0],partida[1]);
	}

	private static boolean escapar(String[][] mazee,int f,int c) {
		
		if(f<0 || f>mazee.length-1 || c<0 || c>mazee[f].length-1) {
			return false;
		}
		
		if(mazee[f][c].equals("."))return false;
		
		if(mazee[f][c].equals(" ")||mazee[f][c].toLowerCase().
				equals("k")) {
			mazee[f][c] = ".";
		}
		
		if(mazee[f][c].equals(".")&&
			(f==0||c==0||f==mazee.length-1||c==mazee[f].length-1)) {
			return true;
		}
		
		if(mazee[f][c].equals("#"))return false;
		
		boolean opc = escapar(mazee,f,c+1);
		
		if(opc)return true;
		
		opc = escapar(mazee,f,c-1);
		
		if(opc)return true;
		
		opc = escapar(mazee,f+1,c);
		
		if(opc)return true;
		
		opc = escapar(mazee,f-1,c);
		
		if(opc) {
			return true;
		}else {
			mazee[f][c] = " ";
		}
		return false;
	}
	
}
