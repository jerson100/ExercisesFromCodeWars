package CuatroKyu;

import java.util.HashSet;

public class CombinacionesDCammbio {

	public static void main(String[] args) {
	
		System.out.println(countChange(10, new int[] {5, 2,3}));
		System.out.println(f(10));
	}
	
	public static int countChange(int amountMoney,int[] denominations) {
		
		//amountMoney = 4
		//denominations = 1,2
		// 1 + 1 + 1 + 1 
		// 1 + 1 + 2 
		// 2 + 2
		
		return count(amountMoney, denominations, 0, "",new HashSet<Integer>());
		
	}
	
	public static int f(int n) {
		return n<3?1:f(n-1)+f(n-2);
	}
	
	//1,2
	
	public static int count(int m,int []d,int s,String c,HashSet<Integer> set) {	
		if(s == m) {
			set.add(order(c.replaceAll("[\\+]", "")));
			System.out.println(c);
		}else {	
			for (int i = 0; i < d.length; i++) {	
				if(s+d[i]<=m) {	
					count(m,d,s+d[i],d[i]+"+"+c,set);
				}
			}
		}
		return set.size();
	}
	
	public static int order(String d) {
		String sp[] = d.split("");
		String t,r="";
		for (int i = 0; i < sp.length; i++) {
			for (int j = i+1; j < sp.length; j++) {
				if(Integer.parseInt(sp[i])>Integer.parseInt(sp[j])) {
					t = String.valueOf(Integer.parseInt(sp[i]));
					sp[i] = sp[j];
					sp[j] = t;
				}
			}
			r += sp[i];
		}
		return Integer.parseInt(r);
	}
	
}
