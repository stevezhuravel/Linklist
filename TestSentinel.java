
public class TestSentinel {

	public static void main(String[] args) {
		SentinelLink<Integer> list = new  SentinelLink<Integer>();
		
			
			
			list.addFirst(5);
			list.addFirst(3);
			list.addFirst(6);
			list.addFirst(9);
			
			list.add(2, 10);
			list.add(3 , 7);
			list.add(1 , 3);
			list.add(0, 8);
			list.add(list.size(), 5);
			
			list.addLast(7);
			list.addLast(12);
			
			
			
			//remove the last elements
			//list.removeLast();
			
			
			// remove the last element
			//list.removeLast();
			
			//remove the first element
			//list.removeFirst();
			
			// pushes the elements onto the stack
			//list.push(12);
			//list.push(3);
			
			// i have //
			//list.poll();
			//list.clear();
			
			//list.remove();
			 
			
		
			//list.pop();
			//list.pop();
			
			//System.out.println("clear " + list.size());
			//System.out.println("poll " + list.size());
			//System.out.println(" size: " + list.size());
			//System.out.println(" push " + list.size());
			
			//System.out.println(list.remove(3));
			//System.out.println("number removed" + list.remove());
			//System.out.println(" size: " + list.size());
			//System.out.println("remove number " + list.removeFirst());
			//System.out.println("remove number " + list.removeLast());
			//System.out.println("removed firstOccurrence " + list.removeFirstOccurrence(new Integer (9)));
			//System.out.println(" size: " + list.size());
			
			
			//System.out.println("remove lastoccurrence " + list.removeLastOccurrence(new Integer (3)));
			
			//returns the last elemnet of the list
			//System.out.println("remove last " + list.removeLast());
			
			//removes and return the first elements
			//System.out.println("remove first " + list.removeFirst());
			
			// retrives and  but does not removes the head
			//System.out.println("peek " + list.peek());
			
			// get the last elements
			//System.out.println("get last " + list.getLast());
			
			// get the first elements
			//System.out.println("get first " + list.getFirst());
			
			//System.out.println("index element," + list.set(0, 5));
			/*System.out.println("Object array");
			for(Object o : list.toArray())
				System.out.println(o);
			
			System.out.println("Regular list");
			*/
			/*Integer[] a = new Integer[list.size()];
			for (Integer i : list.toArray(a))
			System.out.println(i);*/
			//System.out.println(list.addAll(4));
			//tells us if an elements exisit in a list
			//System.out.println("contains " + list.contains(5));
			//System.out.println("offer first " + list.offerFirst(8));
			//System.out.println("offer first " + list.offerFirst(29));
			//System.out.println("offer last " + list.offerLast(12));
			//System.out.println("offer last " + list.offerLast(32));
			
			// remove method by index
			//System.out.println("remove by index " + list.remove(4));
			
			// peek first return but does not remove the first elements and returns null if it empty
			//System.out.println("peek first " + list.peekFirst());
			
			// peek last return but does not remove the last elements or returns null if it empty
		//System.out.println("peek last " + list.peekLast());
			
			//indexOf return the first occurance or return -1
			//System.out.println("indexOf " + list.indexOf(5));
			
			//poll first retrivrs  and removes the first element or return null if it empty
			//System.out.println("poll first " + list.pollFirst());
			//System.out.println("poll first " + list.pollFirst());
			
			//poll last retrieves and removes the first element or return null if it empty
			//System.out.println("poll last " + list.pollLast());
			//System.out.println("poll last " + list.pollLast());
			
			// offer add the element to the tail
			//System.out.println("offer " + list.offer(9));
			
			//set replace the element at the specfic position
			
			//System.out.println(" size: " + list.size(9));
			
			//checks if the element is found or not found
			//System.out.println("contains " + list.contains(new Integer(12)));
			
			//checks if the element is found or not found
			//System.out.println("contains " + list.contains(new Integer(8)));
			
			//checks if the element is found or not found
			//System.out.println("contains " + list.contains(new Integer(18)));
			
			//checks if the element is found or not found
			System.out.println("contains " + list.contains(new Integer(58)));
			list.print();
			
			
			if(list.isEmpty())
				System.out.println("the list is empty");
			else 
				System.out.println("the list is not empty ");
	}

}
