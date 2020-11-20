package powerGrid;

import java.util.*;
public class MyPQ<E> implements DataStructure<E> {
	PriorityQueue<E> a;
	
	public MyPQ(Comparator<E> comp){
		a = new PriorityQueue<E>(10, comp);
	}
	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return a.poll();
	}

	@Override
	public boolean isEmpty() {
		return a.size() == 0;
	}

	@Override
	public void add(E item) {
		// TODO Auto-generated method stub
		a.offer(item);
	}
	public E get(int i) {
		E[] t = (E[]) a.toArray();
		return t[i];
	}
	
	public String toString() {
		return a.toString();
	}

}
