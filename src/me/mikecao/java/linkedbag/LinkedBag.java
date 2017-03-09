package me.mikecao.java.linkedbag;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LinkedBag implements BagInterface {
	public Link firstLink;
	public int numberOfEntries = 0;

	public LinkedBag() {
		firstLink = null;
	}

	public <T> LinkedBag(T firstEntry) {
		this.firstLink = new Link(firstEntry);
		numberOfEntries++;
	}

	public boolean isEmpty() {
		return (firstLink == null);
	}

	public <T> boolean add(T newEntry) {
		Link newLink = new Link(newEntry);
		newLink.setNext(firstLink);
		firstLink = newLink;
		numberOfEntries++;
		return true;
	}

	public <T> T remove() {
		if (firstLink != null) {
			T dummy = (T) firstLink.getItem();
			firstLink = firstLink.getNext();
			numberOfEntries--;
			return dummy;
		}
		return (T) null;
	}

	public <T> boolean remove(T entry) {
		Link currentLink = firstLink;
		Link lastLink = null;
		if (this.contains(entry)) {
			while (currentLink.getItem() != entry) {
				lastLink = currentLink;
				currentLink = currentLink.getNext();
			}
			if (lastLink != null)
				lastLink.setNext(currentLink.getNext());
			else
				firstLink = currentLink.getNext();
			numberOfEntries--;
			return true;
		}
		return false;
	}

	public void clear() {
		firstLink = null;
		numberOfEntries = 0;
	}

	public <T> int getFrequencyOf(T entry) {
		T[] array = this.toArray();
		int counter = 0;
		for (int i = 0; i < getCurrentSize(); i++) {
			if (array[i] == entry)
				counter++;
		}
		return counter;
	}

	public <T> T[] toArray() {
		Link currentLink = firstLink;
		T array[] = (T[]) new Object[getCurrentSize()];
		for (int i = 0; i < getCurrentSize(); i++) {
			array[i] = (T) currentLink.getItem();
			currentLink = currentLink.getNext();
		}
		return array;
	}

	public <T> boolean contains(T entry) {
		T[] array = this.toArray();
		for (int i = 0; i < getCurrentSize(); i++) {
			if (array[i] == entry)
				return true;
		}
		return false;
	}

	public int getCurrentSize() {
		return numberOfEntries;
	}
}
