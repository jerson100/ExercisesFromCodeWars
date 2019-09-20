package CuatroKyu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AignandoNumeroAPalabra {

	public static void main(String[] args) {
	
		System.out.println(convert("CodeWars"));
		
	}
	static long rspt=0;
	static int v = 1;
	public static long convert(String word){
	    Map<String,Long> map = new HashMap<String,Long>();
	    rspt =0;v=1;
	    Arrays.stream(word.split("")).forEach((t)->{
			if(!map.containsKey(t)) {
				map.put(t,map.size()==1?0l:v++);
			}
			rspt = rspt*10 + map.get(t);
	    });
	    return rspt;
	  }
	
	
	
}
