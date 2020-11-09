class Node {
	public int value;
	public Node next;
	Node( int value, Node next ) {
		this.value = value;
		this.next = next;
	}
}

public class example16_05_02 {
	public static void main( String[] args ) {
		Node head = null;
		for ( int i = 9; i >= 0; i-- ) {
			head = new Node( i, head );
		}
		Node ref = head;
		while ( ref != null ) {
			System.out.print( ref.value + " " );
			ref = ref.next;
		}
		System.out.println( "" );
	}
}