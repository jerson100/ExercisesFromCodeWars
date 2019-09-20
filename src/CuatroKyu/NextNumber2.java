package CuatroKyu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NextNumber2 {

	public static void main(String[] args) {
		System.out.println(nextNumber2(202233445566l));
	}
	
	public static long nextNumber2(long n) {
		
		String num = n+"";
		String subCadena;
		Set<String> list;
		Iterator<String> it;
		
		for (int i = 0; i < num.length(); i++) {
			subCadena = num.substring(num.length()-(i+1), num.length());
			System.out.println(subCadena);
			long ne = Long.parseLong(subCadena);
			list = new TreeSet<>();
			permutar("", String.valueOf(ne).split(""),new ArrayList<>(), list, 0);
			it = list.iterator();
			String rs = "", prev="";
			while(it.hasNext()) {
				String nex = it.next();
				if(subCadena.equals(nex)) {
					rs =(prev.equals(""))?nex:prev;
				}
				prev = nex;
			}
			String d = num.substring(0,num.length()-(i+1))+rs;
			if(rs.equals("")||(d.length()>0&&d.charAt(0)=='0'))continue;
			long rspt = Long.parseLong(d);
			if(rspt<n) {
				return rspt;
			}
		}
		return -1;
	}

	public static void permutar(String number,String []dat,
									List<Integer> indices,
									Set<String> rspt,long n) {
		if(number.length()==dat.length) {
			rspt.add(number);
		}else {
			for (int i = 0; i < dat.length; i++) {
				if(!indices.contains(i)) {
					indices.add(i);
					permutar(number + dat[i], dat,indices,rspt,n);
					indices.remove(indices.size()-1);
				}
			}
		}
	}
	
}
