
package Estrutura;

import java.util.ArrayList;
import java.util.Scanner;

	public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

		private Nodo<T> findBefore(Nodo<T> novo) {
			Nodo<T> atual = getHead();
			Nodo<T> anterior = null;

			while (atual != null) {
				int comp = atual.compareTo(novo);
				     if (comp < 0) {
					     anterior = atual;
					         atual = atual.getNext();
				}
				if (comp == 0)
					return atual;
				
				if (comp > 0)
					return anterior;
			}

			return anterior;
		}

	
		
		@Override
		public void insert(Nodo<T> novo)
		{
			Nodo<T> anterior = findBefore(novo);
			if (anterior == null) {
				
				super.insert(novo);
			} 
			
			else {
				
				super.insert(novo, anterior);
			}
		}


		@Override
		public void insert(Nodo<T> novo, Nodo<T> anterior)
		{
			insert(novo);
		}

		@Override
		public void append(Nodo<T> novo)
		{
			insert(novo);
		}

			
				
		
		public static void main(String[] args) {
		ListaOrdenada obj1 = new ListaOrdenada();
			
			ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();
		 	
	 		Nodo<Integer> novo = new Nodo<Integer>(1);
	 		lista.insert(novo);
	 		
	 		lista.insert(new Nodo<Integer>(2), novo);
	 		
	 		lista.append(new Nodo<Integer>(3));
	 		
	 		lista.insert(new Nodo<Integer>(4), novo);
	 		
	 		
	 		
			
	 		
		}

	}

