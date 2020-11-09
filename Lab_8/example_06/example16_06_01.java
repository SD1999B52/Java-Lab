class Node {
	public int value;
	public Node next;
	Node( int value, Node next ) {
		this.value = value;
		this.next = next;
	}
}

class ListF {
	private Node head, tailRec, refRec;
	private String textRec = "";
	
	public void createHead() {
		head = new Node( 0, null );
		Node tail = head;
		for ( int i = 0; i < 9; i++ ) {
			tail.next = new Node( i + 1, null );
			tail = tail.next;
		}
	}
	
	public void createHeadRec() {
		head = new Node( 0, null );
		tailRec = head;
		createHeadRecH( 0 );
	}
	
	private void createHeadRecH( int i ) {
		if ( i < 9 ) {
			tailRec.next = new Node( i + 1, null );
			tailRec = tailRec.next;
			createHeadRecH( i + 1 );
		}
	}
	
	public void createTail() {
		head = null;
		for ( int i = 9; i >= 0; i-- ) {
			head = new Node( i, head );
		}
	}
	
	public void createTailRec() {
		head = null;
		createTailRecH( 9 );
	}
	
	private void createTailRecH( int i ) {
		if ( i >= 0 ) {
			head = new Node( i, head );
			createTailRecH( i - 1 );
		}
	}
	
	public void AddFirst( int newValue ) {
		head = new Node( newValue, head );
	}
	
	public void AddLast( int newValue ) {
		Node newtail = new Node( newValue, null );
		Node ref = head;
		while ( ref.next != null ) {
			ref = ref.next;
		}
		ref.next = newtail;
	}
	
	public void Insert( int newValue, int index ) {
		Node newNode = new Node( newValue, null );
		Node ref = head;
		int k = 1;
		while (( ref.next != null ) && ( k < index )) {
			ref = ref.next;
			k++;
		}
		newNode.next = ref.next.next;
		ref.next = newNode;
	}
	
	public void RemoveFirst() {
		head = head.next;
	}
	
	public void RemoveLast() {
		Node ref = head;
		while ( ref.next.next != null ) {
			ref = ref.next;
		}
		ref.next = null;
	}
	
	public void Remove( int index ) {
		Node ref = head;
		int k = 1;
		while (( ref.next != null ) && ( k < index )) {
			ref = ref.next;
			k++;
		}
		ref.next = ref.next.next;
	}
	
	@Override
	public String toString() {
		String text = "";
		Node ref = head;
		while ( ref != null ) {
			text += ref.value + " ";
			ref = ref.next;
		}
		return text;
	}
	
	public String toStringRec() {
		textRec = "";
		refRec = head;
		toStringRecH();
		return textRec;
	}
	
	private void toStringRecH() {
		if ( refRec != null ) {
			textRec += refRec.value + " ";
			refRec = refRec.next;
			toStringRecH();
		}
	}
}

public class example16_06_01 {
	public static void main( String[] args ) {
		ListF list = new ListF();
		list.createTailRec();
		System.out.println( list.toStringRec());
		list.AddFirst( 99 );
		System.out.println( list.toString());
		list.AddLast( 56 );
		System.out.println( list.toString());
		list.Insert( 66, 6 );
		System.out.println( list.toString());
		list.Remove( 6 );
		System.out.println( list.toString());
	}
}