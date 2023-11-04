package Entregas.segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> first;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
        first = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(isEmpty()) {
			System.out.println("La lista esta vacia");
		}else if(this.size() == 1) {
			Node<T> devolver = this.first;
			this.first = null;
			this.count -= 1;
			return devolver.data;
		}else {
			Node<T> actual = this.first;
			this.first = this.first.next;
			this.first.prev = actual.prev;
			this.first.next = actual.next.next;
			this.count -= 1;
			return actual.data;
		}
		return null;
	}
	
	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if (isEmpty()) {
			System.out.println("La lista está vacía");
		    return null;
		} else if (this.size() == 1) {
	        Node<T> devolver = this.first;
	        this.first = null;
		    this.count -= 1;
		    return devolver.data;
	    } else {
	        Node<T> actual = this.first;
	        while (actual.next != this.first) {
	        	actual = actual.next;
		    }
		    Node<T> devolver = actual;
		    actual.prev.next = this.first;
		    this.first.prev = actual.prev;
	        this.count--;
	        return devolver.data;
	    }
   }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if (isEmpty()) {
	        System.out.println("La lista está vacía");
	        return null;
	    } else {
	        Node<T> actual = this.first;
	        Node<T> nodoAnterior = null;
	        do {
	        	if (actual.data.equals(elem)) {
	        		if (this.size() == 1) {
	        			this.first = null;
		            } else {
		            	if (actual == this.first) {
		            		this.first = actual.next;
		                }
		            	nodoAnterior.next = actual.next;
		            	actual.next.prev = nodoAnterior;
		            }
	        		this.count--;
	        		return actual.data;
	        	}
	        	nodoAnterior = actual;
		        actual = actual.next;
	        } while (actual != this.first);
	    }
		System.out.println("El elemento no se encuentra en la lista");
		return null;
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
			enc = false;
		}else {
			Node<T> actual = this.first;
			while(this.first.prev != actual && !enc) {
				if(actual.data.equals(elem)) {
					enc = true;
				}else {
					actual = actual.next;
				}
			}
		}
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		return enc;
	}

	public T find(T elem) {
		    if (contains(elem)) {
		        Node<T> actual = this.first;
		        do {
		            if (actual.data.equals(elem)) {
		                return actual.data; // Devuelve el elemento si se encuentra en la lista
		            }
		            actual = actual.next;
		        } while (actual != this.first);
		    }
		    return null; // Devuelve null si el elemento no se encuentra en la lista		
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

		private Node<T> actual = first;
		   
		@Override
	    public boolean hasNext() {
	        return actual != null; // Devuelve true si hay un siguiente elemento
		}

		@Override
	    public T next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException(); // Lanza una excepción si no hay más elementos
	        }
	        T data = actual.data;
	        actual = actual.next; // Avanza al siguiente elemento
	        return data;
	    }

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