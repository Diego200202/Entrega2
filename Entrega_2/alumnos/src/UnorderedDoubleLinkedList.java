package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(elem == null) {
			System.out.println("Introduce el elemento que quieres añadir");
		}
		else {
			Node<T> nuevo = new Node<T>();
			nuevo.descr = elem;
			
			if(this.first == null) {
				nuevo.next= nuevo;
				nuevo.prev=nuevo;
				this.first=nuevo;
			}
			else {
				nuevo.next=this.first;
				nuevo.prev=this.first.prev;
				this.first.prev=nuevo;
				this.first.prev.next= nuevo;
				this.first=nuevo;
			}
			this.count++;
		}
	}

	public void addToRear(T elem) {
	// a�ade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(elem == null) {
			System.out.println("Introduce el elemento que quieres añadir");
		}
		else {
			Node<T> nuevo = new Node<T>();
			nuevo.descr = elem;
			
			if(this.first == null) {
				nuevo.next= nuevo;
				nuevo.prev=nuevo;
				this.first=nuevo;
			}
			else {
				this.first.prev.next=nuevo;
				nuevo.prev=this.first.prev;
				nuevo.next=this.first;
				this.first.prev=nuevo;
			}
			this.count++;
	}
}
	
	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!
		if(elem == null) {
			System.out.println("Introduce el elemento que quieres añadir");
		}else {
			Node<T> actual = this.first.next;
			while(actual != first) {
				if(actual.next.descr == target) {
					Node<T> nuevo = new Node<T>();
					nuevo.descr = elem;
					actual.next.prev=nuevo;
					actual.next= nuevo;
					nuevo.next= actual.next;
					nuevo.prev=actual;
					actual=nuevo;
					this.count++;
					return;
					
				}
			actual=actual.next;
			}
			System.out.println("El elemento target no esta en la lista")
		}
		
	}

}
