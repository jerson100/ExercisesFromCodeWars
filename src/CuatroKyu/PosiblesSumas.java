package CuatroKyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PosiblesSumas {

	public static void main(String[] args) {
		
		Set<Integer> s = new LinkedHashSet<>();
		
		all(new ArrayList<>(), s,10, 0);
		
		System.out.println(s);
		
	}
	
	public static List<Integer> getSumAll(int n){
		
		return null;
	}
	
	public static boolean comprobarSimiltud() {return false;}
	
	public static void all(List<Integer> lis,Set<Integer> lis2,int n,int sum) {
		
		if(n==sum) {
			//System.out.println(lis);
			Collections.sort(lis);
			lis2.add(Integer.parseInt(lis.toString().replaceAll("[,| |\\[|\\]]", "")));
			
		}else {
			
			for (int i = 1; i <= n; i++) {
				
				if(sum+i<=n) {
					Integer e = new Integer(i);
					lis.add(e);
					all(lis,lis2,n,sum + i);
					lis.remove(e);
				}
				
			}
			
		}
		
	}
	
}
