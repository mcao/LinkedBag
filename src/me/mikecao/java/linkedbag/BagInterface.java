package me.mikecao.java.linkedbag;

public interface BagInterface {
	public int getCurrentSize();
	public boolean isEmpty();
	public <T> boolean add(T newEntry);
	public <T> T remove();
	public <T> boolean remove(T entry);
	public void clear();
	public <T> int getFrequencyOf(T entry);
	public <T> boolean contains(T entry);
	public <T> T[] toArray();
}
