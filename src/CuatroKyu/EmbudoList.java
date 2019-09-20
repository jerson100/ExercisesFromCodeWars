package CuatroKyu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class EmbudoList<T> {

	public static void main(String[] args) {
		EmbudoList<Integer> em = new EmbudoList<Integer>();
		em.fill(1,2,3,4,5);
		System.out.println("sds");
		System.out.println(em.drip());
		em.recorrer();
	}
	
	public class Nodo<E>{
		
		E element;
		Nodo<E> topLeft;
		Nodo<E> topRight;
		Nodo<E> l;
		Nodo<E> r;
		
		public Nodo(Nodo<E> topLeft,Nodo<E> topRight,E element,Nodo<E> l,Nodo<E> r) {
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.element = element;
			this.l = l;
			this.r = r;
		}
		
		public Nodo(E element) {
			this.element = element;
		}
		
	}
	
	private Nodo<T> start;
	private Nodo<T> end;
	private int size;
	
	public void fill(T...data) {
		for (int i = 0; i < data.length; i++) {
			add(data[i]);
		}
	}
	
	public void add(T e) {
		if(this.isEmpty()) {
			start = end = new Nodo<T>(e);
		}else {
			
			Nodo<T> newNodo = new Nodo<T>(null, null, e, null,null);
		
			if(end.topLeft==null) {
				end.topLeft = newNodo;
			}else if(end.topRight==null) {
				end.topRight = newNodo;
				newNodo.l = end.topLeft;
				end.topLeft.r = newNodo;
				//compruebas que no a la izquierda este null
				//end = end.topLeft;
				if(end.r == null) {
					while(end.l!=null) {
						end = end.l;
					}
					end = end.topLeft;
				}else {
					end = end.r;
					end.topLeft = end.l.topRight;
				}
			}
					
		}
		
		size++;
	}
	
	/**
	 	Este método nos permite eliminar el 
	 	<br>elemento de la parte inferior del enbudo
	 	@author Jerson
	 	@return T
	 */
	
	public T drip() {
		//eliminamos el start
		
		
		Nodo<T> aux = start;
		
		while(aux.topLeft!=null || aux.topRight!=null) {
			
			int[] arr = obtenerLongitud(aux);
			
			if(arr[1]==-1) {
				Nodo<T> tr = aux.topRight;
				Nodo<T> tl = aux.topRight;
				Nodo<T> r = aux.r;
				Nodo<T> l = aux.l;
				
				
				aux.topLeft.topRight = aux.topRight;
				aux = aux.topLeft; 
			}else {
				aux = aux.topRight;
			}
				
			
			
		}
		
		return null;
	}
	
	public int[] obtenerLongitud(Nodo<T> e) {
		if(e!=null) {
			//System.out.print(e.element+" ");
			int left = 1 + obtenerLongitud(e.topLeft)[0];
			System.out.println(left +" ");
			int right = 1 + obtenerLongitud(e.topRight)[0];
			int rspt=1;
			if(left>=right) {
				rspt = -1;
			}
			return new int[] {Math.max(left, right),rspt};
		}
		return new int[] {0,0};
	}
	
	public void recorrer() {
		
		Map<Integer, List<T>> map = new TreeMap<>();
		
		rec(start, map, 0);
		
		Iterator<Entry<Integer, List<T>>> it = map.entrySet().iterator();
		String space = "";
		while (it.hasNext()) {
			Entry<Integer, List<T>> x = it.next();
			System.out.println(space+x
									.getValue()
									.toString()
									.replaceAll("\\["," ")
									.replaceAll("\\]"," ")
									.replaceAll(",", "")
									.replaceAll(" ","     ")
									.trim());
			space+= "   ";
		}
		
	}
	
	
	//se tiene que implementar el metodo equals para poder saber cuando
	//dos objetos son iguales
	private void rec(Nodo<T> start,Map<Integer,List<T>> map,int nivel) {
		if(start!=null) {
			if(!map.containsKey(nivel)) {
				ArrayList<T> l = new ArrayList<>();
				l.add(start.element);
				map.put(nivel, l);
			}else {
				List<T> l = map.get(nivel);
				if(!l.contains(start.element)) {
					l.add(start.element);
				}
			}
			rec(start.topLeft,map,nivel-1);
			rec(start.topRight,map,nivel-1);
		}else {
			if(map.get(nivel)!=null) {
				map.get(nivel).add((T)" ");
			}
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	
	
}
