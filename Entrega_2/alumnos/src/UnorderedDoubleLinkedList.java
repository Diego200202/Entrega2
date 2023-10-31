package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	Node<T>first = super.first();
	
	public void addToFront(T elem) {
		if(this.first == null) {
			this.first = new DoubleNode<Integer>(elem);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			DoubleNode<Integer> actual = this.first.prev;
			actual.next = new DoubleNode<Integer>(elem);
			actual.next.next = this.first;
			this.first = actual.next;
			this.first.prev = actual;
		}
	}
	// a�ade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

	

	public void addToRear(T elem) {
		if(this.first == null) {
			this.first = new DoubleNode<Integer>(pData);
			this.first.next = this.first;
			this.first.prev = this.first;
		}else {
			DoubleNode<Integer> actual = this.first.prev;
			actual.next = new DoubleNode<Integer>(pData);
			actual.next.next = this.first;
			this.first.prev = actual.next;
			actual.next.prev = actual;
		}
	// a�ade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

	}
	
	public void addAfter(T elem, T target) {
		Node<T> actual = this.first;
		Node<T> previo = this.first.prev;
		boolean enc = false;
		
		if(target != this.first.data) {
			previo = actual;
			actual = actual.next;
			while(actual != this.first && actual.data != target) {
				previo = actual;
				actual = actual.next;
				if(actual.data == target) {
					enc = true;
				}
			}
			if(enc) {
				previo = actual;
				actual = actual.next;
				
				actual.prev = new DoubleNode<T>(elem);
				actual.prev.next = actual;
				actual.prev.prev = previo;
				previo.next = actual.prev;
			}else {
				actual.prev = new DoubleNode<T>(elem);
				actual.prev.next = actual;
				actual.prev.prev = previo;
				this.first = actual.prev;
				previo.next = this.first;
			}
		}else {
			previo = actual;
			actual = actual.next;
			
			actual.prev = new DoubleNode<T>(elem);
			actual.prev.next = actual;
			actual.prev.prev = previo;
			previo.next = actual.prev;
		}
	}
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!

}
