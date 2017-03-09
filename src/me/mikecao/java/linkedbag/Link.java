package me.mikecao.java.linkedbag;

public class Link<E> {
	private Link<E> next;
	private E item;
	
	public Link(E item) {
		this.item = item;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean setNext(Link next) {
		this.next = next;
		return true;
	}

	public boolean hasNext() {
		return (next == null);
	}
	
	public E getItem() {
		return item;
	}
	
	@SuppressWarnings("rawtypes")
	public Link getNext() {
		return next;
	}
}
