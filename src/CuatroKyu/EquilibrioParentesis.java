package CuatroKyu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EquilibrioParentesis {

	public static void main(String[] args) {
		
		/*long in = System.currentTimeMillis();
		
		System.out.println(balancedParens(3));
		
		System.out.println("fin; "+((System.currentTimeMillis()-in)/1000.0));*/
		
		for (int i = 1; i < 8; i++) {
			System.out.println("balance("+i+")=> "+balancedParens(i));
		}
		
	}
	
	public static List<String> balancedParens (int n) {
		String salida="",inicio="";
		Set<String> rspt = new HashSet<>();
		for (int i = 0; i < n; i++) {
			salida = "("+salida+")";
			inicio += "()";
		}
		solution(salida, inicio, rspt);
        return new ArrayList<>(rspt);
    }
	
	public static void solution(String salida,
								String inicio,
								Set<String> list) {
		list.add(inicio);
		if(!inicio.equals(salida)) {
			for (int i = 0; i < inicio.length(); i++) {
				if(i>0 && i<inicio.length() && inicio.charAt(i)==')') {
					String s = nextReplace(i, inicio);
					if(s==null||list.contains(s)) continue;
					solution(salida, s,list);
				}
			}
		}
	}
	
	public static String nextReplace(int x,String data) {
		String xx = data.charAt(x)+"";
		int yy = -1;
		for (int i = x+1; i < data.length(); i++) {
			if(data.charAt(i)=='(') {
				yy = i;
				break;
			}
		}
		if(yy==-1)return null;
		return data.substring(0, x)+data.charAt(yy)+
			   data.substring(x+1, yy)+xx+data.substring(yy+1);
	}
	
}
