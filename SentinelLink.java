import java.util.*;
public class SentinelLink<E> {
	protected Node s;
	
	// creating an Iterator class
	private class MyIterator implements Iterator<E>{		
		protected Node nextNode,returned;
		protected int index;
		// constructor for iterator
		public MyIterator(Node pointer,int index) {
			
			// setting next node to pointer
			 this.nextNode=pointer;
			 // setting insex to it self keep track
			 this.index=index;
	
		}
		public boolean hasNext() {
			return nextNode!=s;
		}
		
		
		
		public E prev() {
			if(!this.hasPrev())throw new NoSuchElementException();
			E num = nextNode.prev.data;
			returned=nextNode.prev;
			nextNode=nextNode.prev;
			index--;
			return num;
		}
		
		
		public boolean hasPrev() {
			return nextNode.prev !=s;
		}
		public E next() {
			if(!this.hasNext()) throw new NoSuchElementException();
			E num =nextNode.data;
			returned=nextNode.prev;
			nextNode=nextNode.next;
			index++;
			return num;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class Node{
		
		private E data;
		protected Node next, prev;
		
		public Node() {}
		public Node(E data) {
			
			this.data = data;

		}
		
		//
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
		public SentinelLink<E>.MyIterator Iterator() {
			return new MyIterator(next, len);
		}
	}
	
	
	public int len;
	
	public SentinelLink(){
		s = new Node();
		s.next = null;
		s.prev = null;
	}
	// prints the linklist out
	public void print() {
		Node temp = s;
		while(temp.next != s) {
			temp = temp.next;
			System.out.println(temp.data);
		}
	}
	// tells us if the elements is or is not found
	public boolean contains(Object o) {
		Node temp = s.next;
		
		while(temp.hasNext()) {
			if(temp.data.equals(0))
				return true;
			temp = temp.next;
		}
		
		return false;
	}
	// removes the first element of the list 
	//unlocking each node
	public E removeFirst() {
		
		Node temp = s.prev;
		s.next = s.next.next;
		s.next.prev = s;
		len --;
		return temp.data;
	}
	// add the elements to the frount of the list
	// increase the length after each add
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
	// construct an empty list
	public boolean isEmpty() {
		return len == 0;
}
	// return the size of the list 
	public int size() {
			return len;
		
	}
	// add the element to a specfic element of the list 
	// throws indexoutofboundsexception
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
			for(int i = 0; i <= ind-1; i++) 
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
	// add the element to the end of the list
	public boolean add(E data) {
		addLast(data);
		return true;
	}
	// clear the list and it sets the size to be zero
	public void clear() {
		s.prev = s;
		s.next = s;
		len = 0;
	}
	
	// remove the first occurrence of a number in the list
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
	
	// remove the last element the occurrecus in the list
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
	
	// remove the last element of the list
	public E removeLast() {
		Node temp = s.next;
		s.prev = s.prev.prev;
		s.prev.next = s;
		len --;
		return temp.data;
	}
	// Removes the first occurrence of the specified element from this list, if it is present
	// throw nosuchelementexception
	// return the first element in the list
	public E remove() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		return removeFirst();

		
	}
	// remove a specfic element of the list by index
	// unlocking  nodes
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
	// get the last element but does not remove it 
	public E getLast() {
		return s.prev.data;
	}
	// get the first element of the list but does not remove
	public E getFirst(){
		return s.next.data;
	}
	
	// gets the elements but does not return it 
	public E element() {
		return s.next.data;
	}
	// retervies the element
	public E peek() {
		return element();
	}
	// retervies the first element of the list but it does not remove it 
	// returns the first element of the list
	public E peekFirst() {
		
		if(s.next == null)
			return null;
		return element();
	}
	// retervies the last element of the list but it does not remove it
	// return the last element of the list
	public E peekLast() {
		if(s.prev == null)
			return null;
		return s.prev.data;
	}
	
	//  replaces the element by index
	public E set(int index, E element) {
		Node temp = s.next;
		
		for(int i = 0; i <= index; i++) {
			temp = temp.next;
			
		}
		 E	num = temp.data;
			temp.data = element;
			return num;
	}
	// add the element to the end of the list
	// unlocking nodes
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
		// increase the size
		len++;
	}
	// removes the head of the element
	public boolean remove(Object o) {
		Node temp = s;
		while(temp.hasNext()) {
			if(temp.next.data.equals(o)) {
				return true;
			}
		}
		 return false;
	}
	//
	public boolean addAll(Collection<? extends E> c) {
		
		Iterator<? extends E> iter = c.iterator();
		while(iter.hasNext()) {
			this.add(iter.next());
		}
		return false;
	
		}
	
	// return the list in descending/backwards order
	public Iterator<E>	descendingIterator(){
		// creating an iterator
		MyIterator listiter = s.Iterator();
		 while(listiter.hasNext()){
			 return listiter;
	}
		return  listiter;
		
	}
	
	// return the index of the first occuring of the element that you are looking for
	public int indexOf(Object o) {
		// starting of count at 0
		int count = 0;
		Node cmd = s.next;
		while(cmd.hasNext()) {
			    
		   if(cmd.data.equals(o)) {

				 return count;
			}
		   // set node to the next node
		   cmd = cmd.next;
	      // increases count
          count ++;
		}
		// returns -1 if it does not find it
		return -1;
	}
	
	// return the last index of the element that you are looking you
	public int lastIndexOf(Object o) {
		// starting count at len - 1
		int count = len -1;
		// last node
		Node cmd = s.prev;
		while(cmd.hasPrev()) {
		if(cmd.data.equals(o)) {
			return count;
			}
			//System.out.println(o + " is not equal to  " + cmd.data);
			cmd = cmd.prev;
			count --;
		}
		 //returns -1 if the element is not found
		return -1;
	}
	
	public ListIterator<E>listIterator(int index){
		
		if(index < 0 || index > len) throw new IndexOutOfBoundsException();
		MyIterator listiter = s.Iterator();
			while(listiter.hasNext()) {
				listiter.next();
			}
			return (ListIterator<E>) listiter;
				}
		
			
		
		
			
	
		
	// add the element to the end as it tail
	// creating an node reference
	public boolean offer(E e) {
		Node temp = s;
		Node cmd = new Node(e);
		while(temp.hasNext()) {
			temp= temp.next;
			cmd = temp.next;
			cmd.next = s;
			s.prev = cmd;
			
		}
		// returns true if it was able to add the element
		return true;
	}
	// insert the element to the front of the list
	public boolean	offerFirst(E e) {
		addFirst(e);
		return true;
	}
	// insert the element to the end of the list
	public boolean	offerLast(E e) {
		addLast(e);
		// retuns true
		return true;
	}
	// retervies and remove the head
	public E poll() {
		Node cmd = s.next;
		if(s.isEmpty())
			return null;
		cmd.next.prev = s;
		cmd.prev.next = cmd.next;
		
		return remove();
		
	}
	//retervies and remove the first element of the list
	public E pollFirst() {
		if(s.next == null)
			return null;
		return remove();
	
	}
	//retervies and remove the last element of the list
	public E pollLast() {
		if(s.prev == null)
			return null;
		return removeLast();
	}
	// removes the last element of the list
	public E pop() {
		return removeLast();
		
	}
	// add amd element to the list
	public void push(E e) {
		add(e);
		
	}
	// returns and array and it contains all the elements that are in the list 
	public Object[]	toArray() {
		Object[] arr  = new Object[len];
		Node temp = s.next;
		
		for(int i = 0; i < len; i++ ) {
			arr[i] = temp.data;
			temp = temp.next;
		}
		
		return arr;
	}
	// returns and array is order from head to tail
	public <T> T[]	toArray(T[] a) {
		if(a.length < len)
			throw new ArrayStoreException();
		Node temp = s.next;
		
		// loop to go through the array to length
		for(int i = 0; i < len; i++ ) {
			a[i] = (T) temp.data;
			temp = temp.next;
		}
		
		return a;
	}
}