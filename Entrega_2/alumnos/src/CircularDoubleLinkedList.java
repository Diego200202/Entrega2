package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
        this.first = null;
		this.descr = "";
		this.count = 0;
	}
	
	public void setDescr(String nom) {
		this.descr = nom;
	}

	public String getDescr() {
	  return this.descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(isEmpty()) {
			return null;
		}else if(this.size() == 1) {
			this.first = null;
			this.first.next = null;
			this.first.prev = null;
		}else {
			Node<T> actual = this.first;
			this.first = this.first.next;
			this.first.prev = actual.prev;
			this.first.next = actual.next.next;
		}
		this.count -= 1;
		return actual.data;
	}
	
	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(isEmpty()) {
			return null;
		}else if(this.size() == 1) {
			this.first = null;
			this.first.prev = null;
			this.first.next = null;
			return this.first;
		}
		else {
			Node<T> actual = this.first.prev;
			actual.prev.next = this.first;
			this.first.prev = actual.prev;
		}
		count -= 1;
		return actual.data;
   }

//
	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(this.isEmpty()) {
			return null;
		}else if(this.size() == 1 && this.first.data.equals(elem)) {
			this.first = null;
			this.first.prev = null;
			this.first.next = null;
			return this.first().data;
		}else if(this.size() == 1 && !this.first.data.equals(elem)) {
			return null;
		}else {
			Node<T> actual = this.first;
		}
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return this.first.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
		boolean enc = false;
		
		if (isEmpty()) {
			return false;
		}else {
			Node<T> actual = this.first;
			while(actual.next != this.first && !enc) {
				if(this.size() == 1) {
					if(actual.data.equals(elem)) {
						enc = true;
					}
				}
				else {
					if(actual.data.equals(elem)) {
						enc = true;
					}else {
						actual = actual.next;
					}
				}
			}
		}
		return enc;// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
	}

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

	}

	public boolean isEmpty() 
	//Determina si la lista est� vac�a
	{ return first == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE



	   } // private class
		
		
         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "DoubleLinkedList " + result + "]";
		}

}
