package CuatroKyu;

public class TiraComentarios {

	public static void main(String[] args) {

		System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples",
				new String[] { "#", "!" }));
		
		System.out.println("wdwdwdwd;dewdede".replaceAll("[;].*", ""));
		
	}

	public static String stripComments(String text, String[] commentSymbols) {
		String data[] = text.split("\n");
		String rspt = "", aux = "";
		String salto = "\n";
		
		for (int i = 0; i < data.length; i++) {

			aux = data[i].replaceAll("[ ]+$", "");
			
			if(i == data.length-1) {
				
				salto = "";
				
			}else {
				
				aux += salto;
				
			}	
			
			for (int j = 0; j < commentSymbols.length; j++) {

				int index = data[i].indexOf(commentSymbols[j]);

				if (index != -1) {
					
					aux = data[i].substring(0, index).replaceAll("[ ]+$", "").concat(salto);
					break;
				}

			}
			
			rspt += aux;

		}

		return rspt;
		
	}

}
