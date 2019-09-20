package CuatroKyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Ordenar {

	public static void main(String[] args) {
		/*
		List<Integer> s = new ArrayList<>();
		s.add(1);
		s.add(10);
		s.add(11);
		s.add(21);
		
		Predicate<Integer> pr = (Integer t) -> t>5;
		Function<Integer,Integer> i = (Integer t)->t+2;
		
		s.stream().filter(pr).forEach((t)->{System.out.println(t);});
		s.stream().map(i).forEach(x->System.out.println(x));
	*/
		//order("Humble Bundle");
		
		String[] d = {
			"s","s","e"	
		};
		
		System.out.println(String.join("",d));
		
		long i = System.currentTimeMillis();
		
		BWT encode = encode("Banana");
		
		System.out.println("encode ->"+encode.s);
		
		String decode = decode(encode.s, encode.n);
		
		System.out.println("decode ->"+decode);
		
		System.out.println((System.currentTimeMillis()-i)/1000.0);
		
	}
	
	public static class BWT {

	    public String s;
	    public int n;

	    public BWT(String s, int n) {this.s = s;this.n=n;}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + n;
			result = prime * result + ((s == null) ? 0 : s.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BWT other = (BWT) obj;
			if (n != other.n)
				return false;
			if (s == null) {
				if (other.s != null)
					return false;
			} else if (!s.equals(other.s))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return s;
		}


	}
	
	 public static BWT encode(String s) {
	        String m[][] = obtenerMatriz(s);
	        ordenarXFila(m, 0);
	        String rspt="";
	        int n=-1;
	        for (int i = 0; i < m.length; i++) {
				rspt+= m[i][m.length-1];
				if(String.join("",m[i]).equals(s))n = i;
			}
	        return new BWT(rspt, n);
	    }
	    
	     public static String decode(String s, int n) {
	    	if(n<0||s.length()==0)return "";
	        String[][] m = new String[s.length()][s.length()];       
	        for (int i = m.length-1; i>=0 ; i--) {
	        	for (int j = 0; j < m.length; j++) {
	        		m[j][i] = s.charAt(j)+""; 
				}
	        	ordenarXFila(m,i);
	        }
	    	return String.join("", m[n]);
	    	
	    }
		
	    private static void ordenarXFila(String[][] data, int k) {
	    	for (int i = 0; i < data.length; i++) {
				for (int j = i+1; j < data.length; j++) {
					for (int j2 = k; j2 < data[j].length; j2++) {
						if(data[i][j2].compareTo(data[j][j2])>0) {
							String fi[] = data[i];
							String fj[] = data[j];
							data[i] = fj;
							data[j] = fi;
							break;
						}else if(data[i][j2].compareTo(data[j][j2])<0) {
							break;
						}
					}
				}
			}
		}

		public static String[][] obtenerMatriz(String d) {
			String data[][] = new String[d.length()][d.length()];
			for (int i = 0; i < data.length; i++) {
				data[i] = d.split("");
				d = (d.charAt(d.length()-1)+""+d.substring(0, d.length()-1));	
			}
			return data;
	    }
	}
	
	

