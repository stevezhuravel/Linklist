import java.util.*;
public class SentinelLink<E> {
	
	private class MyIterator implements Iterator<E>{		
		private Node pointer; 
		
		public MyIterator() {
			
			pointer = s.getNext();
			
		}
		public boolean hasNext() {
			return false;
		}
		public E next() {
			return null;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	private class Node{
		
		private E data;
		private Node next, prev;
		
		public Node() {}
		public Node(E data) {
			
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		
		//faisal
		public E getData() {
			return data;
		}
		public Node getNext() {
			return next;
		}
		public Node getPrev() {
			return prev;
		}
		
		public void setData(E data) {
			this.data = data;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public void setPrev(Node Prev) {
			this.prev = prev;
		}
		
		public boolean hasNext() {
			return next != s;
		}
		public boolean hasPrev() {
			return prev != s;
		}
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}
		public Iterator<E> Iterator() {
			return null;
		}
	}
	
	private Node s;
	public int len;
	
	public SentinelLink(){
		s = new Node();
		s.next = null;
		s.prev = null;
	}
	
	public void print() {
		Node temp = s;
		while(temp.next != s) {
			temp = temp.next;
			System.out.println(temp.data);
		}
	}
	public boolean contains(Object o) {
		Node temp = s.next;
		
		while(temp.hasNext()) {
			if(temp.data.equals(0))
				return true;
			temp = temp.next;
		}
		
		return false;
	}

	public E removeFirst() {
		
		Node temp = s.prev;
		s.next = s.next.next;
		s.next.prev = s;
		len --;
		return temp.data;
	}
	
	public void addFirst(E data) {
		Node nmd = new Node(data);
		
		if(s.next == null) {
			s.next = nmd;
			nmd.prev = s;
			nmd.next = s;
			s.prev = nmd;
		}else {
			nmd.next = s.next;
			nmd.prev = s;
			s.next.prev = nmd;
			s.next = nmd;		
		}
		

		len++;
	}
	
	public boolean isEmpty() {
		return len == 0;
}
	public int size() {
			return len;
		
	}
	
	public void add(int ind, E data ) {
		if(ind > len)
			throw new IndexOutOfBoundsException();
		
		Node nmd= new Node(data);
		Node temp = s;
		
		if(ind == 0)
			addFirst(data);
		else if(ind == len - 1)
			addLast(data);
		else {
			for(int i = 0; i <= ind; i++) 
				temp = temp.next;
			
			nmd.next = temp;
			nmd.prev = temp.prev;
			temp.prev = nmd;
			nmd.prev.next = nmd;
		}
		
		len ++;
	}
	
	private SentinelLink<E>.Node Next() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(E data) {
		addLast(data);
		return true;
	}
	
	public void clear() {
		s.prev = s;
		s.next = s;
		len = 0;
	}
	
	public boolean removeFirstOccurrence(Object o) {
		Node temp = s.next;
		while(temp.hasNext()) {
			if(temp.data.equals(o)) {
				temp.next.prev = temp.prev;
				temp.prev.next = temp.next;
				len--;
				return true;
			}
			temp = temp.next;	
		}
			
		return false;
	}	
	
	public boolean removeLastOccurrence(Object o) {
		Node temp = s.next;
		while(temp.hasPrev()){
			if(temp.data.equals(o)) {
				temp.prev.next= temp.next;
				temp.next.prev = temp.prev;
				len--;
				return true;
			}
			temp = temp.prev;	
		}
			
		return false;
	}	
	
	public E removeLast() {
		Node temp = s.next;
		s.prev = s.prev.prev;
		s.prev.next = s;
		len --;
		return temp.data;
	}
	public E remove() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		return removeFirst();

		
	}
	
	public E remove(int index) {
		Node temp = s;
		if(index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		for(int i = 0; i <= index; i++) 
			temp = temp.next;
			
			temp.next.prev = temp.prev;
			temp.prev.next = temp.next;
			temp.next = null;
			temp.prev = null;
			len --;
			return temp.data;
	}
	public E getLast() {
		return s.prev.data;
	}
	
	public E getFirst(){
		return s.next.data;
	}
	
	public E element() {
		return s.next.data;
	}
	
	public E peek() {
		return element();
	}
	public E peekFirst() {
		
		if(s.next == null)
			return null;
		return element();
	}
	
	public E peekLast() {
		if(s.prev == null)
			return null;
		return s.prev.data;
	}
	
	public E c() {
		Node temp = s.next;
		s.next = s.next.next;
		s.next.prev = s;
		len --;
		return temp.data;
	}
	public E set(int index, E element) {
		Node temp = s.next;
		
		for(int i = 0; i <= index; i++) {
			temp = temp.next;
			
		}
		 E	num = temp.data;
			temp.data = element;
			return num;
	}
	
	public void addLast(E e) {
	Node nmd = new Node(e);
		if(s.next == null) {
			s.next = nmd;
			s.prev = nmd;
			nmd.prev = s;
			nmd.next = s;
		}else {
			nmd.next = s;
			s.prev.next =  nmd;
			nmd.prev = s.prev;
			s.prev = nmd;	
		}

		len++;
	}
	public boolean remove(Object o) {
		Node temp = s;
		while(temp.hasNext()) {
			if(temp.next.data.equals(o)) {
				return true;
			}
		}
		 return false;
	}
	
	public boolean addAll(Collection<? extends E> c) {
		
		Iterator<? extends E> iter = c.iterator();
		while(iter.hasNext()) {
			this.add(iter.next());
		}
		return false;
	
		}
	public boolean addAll(int index, Collection<? extends E> c) {
		
	}
	
	
	public Iterator<E>	descendingIterator(){
		return new MyIterator();
	
	}
	public int indexOf(Object o) {
		int count =0;
		Node cmd = s.next;
		while(cmd.hasNext()) {
			cmd=cmd.next;
			count++;
			
		   if(cmd.next.data.equals(o)) {
				return count;
			}
		}
		return -1;
	}
	public int lastIndexOf(Object o) {
		int count = 0;
		Node cmd = s.prev;
		while(cmd.hasPrev()) {
		cmd = cmd.prev;
		count ++;
		}
		if(cmd.prev.data.equals(o)) {
			return count;
		}
		return -1;
	}
	
	public ListIterator<E>	listIterator(int index){ 
		/*if(index < 0 || index < size())throw new IndexOutOfBoundsException();
		Iterator<E> list = s.Iterator();
		while(list.hasNext()) {
			list.next();
			return list.data();
		}*/
			
	}
		
	
	public boolean offer(E e) {
		Node temp = s;
		Node cmd = new Node(e);
		while(temp.hasNext()) {
			temp= temp.next;
			cmd = temp.next;
			cmd.next = s;
			s.prev = cmd;
			
		}
		return true;
	}
	public boolean	offerFirst(E e) {
		addFirst(e);
		return true;
	}
	public boolean	offerLast(E e) {
		addLast(e);
		return true;
	}
	public E poll() {
		Node cmd = s.next;
		if(s.isEmpty())
			return null;
		cmd.next.prev = s;
		cmd.prev.next = cmd.next;
		
		return remove();
		
	}
	public E pollFirst() {
		if(s.next == null)
			return null;
		return remove();
	
	}
	public E pollLast() {
		if(s.prev == null)
			return null;
		return removeLast();
	}
	
	public E pop() {
		return removeLast();
		
	}
	
	public void push(E e) {
		add(e);
		
	}
	
	public Object[]	toArray() {
		Object[] arr  = new Object[len];
		Node temp = s.next;
		
		for(int i = 0; i < len; i++ ) {
			arr[i] = temp.data;
			temp = temp.next;
		}
		
		return arr;
	}
	
	public <T> T[]	toArray(T[] a) {
		if(a.length < len)
			throw new ArrayStoreException();
		Node temp = s.next;
		
		for(int i = 0; i < len; i++ ) {
			a[i] = (T) temp.data;
			temp = temp.next;
		}
		
		return a;
	}
}