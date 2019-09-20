package CuatroKyu;

public class EncriptorVignere {

	private String pass;
	
	public static void main(String[] args) {
		
		EncriptorVignere en = new EncriptorVignere("attackatdawn");
		//System.out.println(en.encode("codewars"));
		System.out.println(en.encode("shr1i"));
									//attackatdawn
	}
	
	
	public EncriptorVignere(String pass) {
		this.pass = pass;
	}
	
	public String encode(String texto) {
		int a = 'a',acu,mov,indexT = 0;
		String rspt = "";
		for (int i = 0; i <texto.length(); i++,indexT++) {
			if(indexT>=pass.length())indexT = 0;
			if(texto.charAt(i)<'a' || texto.charAt(i)>'z') {
				rspt += ((texto.charAt(i)+"").equals("'")?"\\":"")+texto.charAt(i);
				continue;
			};
			acu = (texto.charAt(i) + pass.charAt(indexT) - a );
			mov = (acu=='z')? 'z':(acu % 'z' + (acu>'z'?a-1:0));
			rspt+= (char)mov;
		}
		return rspt;
	}
	
	public String decode(String texto) {
		int a = 'a',acu,indexT = 0;
		String rspt = "";
		for (int i = 0; i <texto.length(); i++) {
			if(indexT==pass.length())indexT = 0;
			if(texto.charAt(i)<'a' || texto.charAt(i)>'z') {
				rspt += texto.charAt(i);
				indexT++;
				continue;
			}
			if(pass.charAt(indexT) <= texto.charAt(i)) {
				acu = texto.charAt(i)-pass.charAt(indexT) + a;
			}else {
				acu = ((int)'z') - pass.charAt(indexT) + texto.charAt(i) +1;
			}
			rspt+= (char)acu;
			indexT++;
		}
		return rspt;
	}
	
	
}
