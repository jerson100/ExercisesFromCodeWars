package CuatroKyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Decompose {

	public static void main(String[] args) {

		int i = 'p';
		int f = 'l';
		int a = 'a';
		int acu=0;
		
		if(i < f) {
			acu = f-i + a;
		}else {
			acu = ((int)'z') - i + f + 1;
		}
		System.out.println(acu);
		
		System.out.println((char)acu);
		
		/*
		 * List<Integer> l = new ArrayList<>(); l.add(4); Set<String> s = new
		 * LinkedHashSet<>();
		 * 
		 * enumm(4, l,s);
		 * 
		 * Iterator<String> it = s.iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 *//*
		long n = 1234567;
		long numG;
		
		System.out.println("-----------------Secuencia estrictamente creciente-----------------\nPruebas:");
		
		for (int i = 0; i < 5; i++) {
			numG = generarNumAleatorio(5, 50);
			System.out.printf("%s\t=\t%s\t%s%s\n",numG+"^2",(long)Math.pow(numG, 2)," = ",decompose(numG));
		}
		
		for (int i = 0; i < 5; i++) {
			numG = generarNumAleatorio(11, 500);
			System.out.printf("%s\t=\t%s\t%s%s\n",numG+"^2",(long)Math.pow(numG, 2)," = ",decompose(numG));
		}
		
		for (int i = 0; i < 5; i++) {
			numG = generarNumAleatorio(1051, 181892851);
			System.out.printf("%s\t=\t%s\t%s%s\n",numG+"^2",(long)Math.pow(numG, 2)," = ",decompose(numG));
		}
		*/
		//decompose(11);
		//System.out.println(decompose(n));

		/*
		 * long i = System.currentTimeMillis(); System.out.println(decompose(60000000));
		 * System.out.println(((System.currentTimeMillis()-i)));
		 */
		/*
		
		Set<String> s = new TreeSet<>();
		List<Integer> w = new ArrayList<>();
		w.add(10);
		
		enumm(10, w, s);
		
		Iterator<String> it = s.iterator();
		
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.println(string);
			
		}*/
		
		System.out.println(caballero("a1", "f1"));
		
	}
	
	public static long generarNumAleatorio(long i,long f) {
		return ((long)(Math.random()*(f-i+1))) + i;
	}
	
	public static String decompose(long n) {
		List<List<Long>> l = new ArrayList<>();
		descompose(0, (long)(Math.pow(n, 2)), n, new ArrayList<>(),l);
	    if(l.size()!=0){
	      l.get(0).sort((s1,s2)->s1.compareTo(s2));
	    }
		return (l.size() == 0) ? null : l.get(0)
                                    .toString()
                                    .replaceAll("[\\[\\]|,]", "")
                                    .replaceAll("[ ]","^2 + ").concat("^2");
	}

	private static void descompose(long acu, long pow,
								   long k,List<Long> num,
								   List<List<Long>> list) {
		if (acu == pow) {
			list.add(new ArrayList<>(num));
		}else {
			for (long i = k-1; i >= 1 && list.size()<1; i--) {
				long a = (long) Math.pow(i, 2),s = new Long(i);
				if (a + acu > pow || (num.contains(s)))continue;
				num.add(s);
				descompose(acu + a, pow, i,num,list);
				num.remove(s);
			}
		}
	}


	
	//esto es de otro ejercicio

	public static void enumm(int n, List<Integer> l, Set<String> set) {
		if (evaluar(l)) {
			System.out.println("-----");
		} else {
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i) <= 1)continue;
				int x = l.get(i);
				l.remove(i);
				for (int j = 1; j <= n / 2; j++) {
					int d = x - (j);
					if (d < 1)
						continue;
					ArrayList<Integer> it = new ArrayList<>(l);
					it.add(d);
					it.add(j);
					Collections.sort(it);
					// it.sort((s1,s2)->s1.compareTo(s2));
					set.add(it.toString());
					enumm(n, it, set);
				}
				l.add(i, x);
			}
		}
	}
	
	public static int caballero(String p1,String p2) {
		
		int h = (int)'a';//obtenemos el valor en ascci de a
		
		String fil = "abcdefgh";
		
		int [][] tablero = new int[8][8];
		ArrayList<String>  d = new ArrayList<>();
		int s = caballe(tablero,
				Integer.parseInt(""+p1.charAt(1))-1,Integer.parseInt(""+fil.indexOf(p1.charAt(0))),
				Integer.parseInt(""+p2.charAt(1))-1,Integer.parseInt(""+fil.indexOf(p2.charAt(0))),
				0,new ArrayList<String>(),d);
		System.out.println(d);
		return s;
		
	}
	
	private static int caballe(int [][]tablero,int f1,int c1,int f2,int c2,int count,List<String> l,List<String> l2) {
		
		if(f1<0||f1>=tablero.length || c1<0||c1>=tablero.length || l.contains(f1+""+c1)) {
			return -1;
		}
		
		System.out.println("F1: "+f1+" c1: "+c1+" - "+"F2: "+f2+" c2: "+c2);
		
		if(f1==f2 && c1==c2) {//si llega a su destino entonces...
			System.out.println("--------------------------F1: "+f1+" c1: "+c1+" - "+"F2: "+f2+" c2: "+c2+" = "+count);
			return count;
		}

		//de manera vertical
		
		int opc;
		
		l.add(f1+""+c1);
		l2.add(f1+""+c1);
		
		opc = caballe(tablero, f1 + 2, c1 - 1, f2, c2,count+1,l,l2);//2t + 1l
		if(opc!=-1) {
			return count;
		}
		
		opc = caballe(tablero, f1 + 2, c1 + 1, f2, c2,count+1,l,l2);//2t + 1r
		if(opc!=-1) {
			return count;
		}
		
		opc = caballe(tablero, f1 - 2, c1 - 1, f2, c2,count+1,l,l2);//2b + 1z
		if(opc!=-1) {
			return count;
		}
		opc = caballe(tablero, f1 - 2, c1 + 1, f2, c2,count+1,l,l2);//2b + 1d
		if(opc!=-1) {
			return count;
		}
		
		//de manera horizontal
		
		opc = caballe(tablero, f1 + 1, c1 - 2, f2, c2,count+1,l,l2);//2l + 1t
		if(opc!=-1) {
			return count;
		}
		opc = caballe(tablero, f1 - 1, c1 -2, f2, c2,count+1,l,l2);//2l + 1b
		if(opc!=-1) {
			return count;
		}
		
		opc = caballe(tablero, f1 + 1, c1 + 2, f2, c2,count+1,l,l2);//2r + 1t
		if(opc!=-1) {
			return count;
		}
		opc = caballe(tablero, f1 - 1, c1 + 2, f2, c2,count+1,l,l2);//2r + 1b
		if(opc!=-1) {
			return count;
		}
		l2.removeAll(null);
		return -1;
		
	}
	

	public static boolean evaluar(List<Integer> l) {
		for (Integer integer : l) {
			if (integer > 1)
				return false;
		}
		return true;
	}

}