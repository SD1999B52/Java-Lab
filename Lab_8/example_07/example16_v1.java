import java.util.Scanner;

class Node {
	public int value;
	public Node next;
	Node( int value, Node next ) {
		this.value = value;
		this.next = next;
	}
}

class ListF {
	private Node head;
	private int minIndex = 0, maxIndex = 0;
	
	public void AddFirst( int newValue ) {
		head = new Node( newValue, head );
	}
	
	public void AddLast( int newValue ) {
		if ( head == null ) {
			head = new Node( newValue, null );
		} else {
			Node newtail = new Node( newValue, null );
			Node ref = head;
			while ( ref.next != null ) {
				ref = ref.next;
			}
			ref.next = newtail;
		}
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
	
	public int sumNodeDiv3() {
		int sum = 0;
		Node ref = head;
		while ( ref != null ) {
			if ( ref.value % 3 == 0 ) {
				sum += ref.value;
			}
			ref = ref.next;
		}
		return sum;
	}
	
	public int colNodeDiv3() {
		int col = 0;
		Node ref = head;
		while ( ref != null ) {
			if ( ref.value % 3 == 0 ) {
				col += 1;
			}
			ref = ref.next;
		}
		return col;
	}
	
	public double sredNodeDiv3() {
		return sumNodeDiv3() / colNodeDiv3();
	}
	
	public int minNodeDiv3() {
		Node ref = head;
		int min = 0, minind = 0;
		boolean minFound = false;
		while ( ref != null ) {
			if ( ref.value % 3 == 0 ) {
				if ( minFound == false ) {
					min = ref.value;
					minFound = true;
					minIndex = minind;
				} else {
					if ( ref.value < min ) {
						min = ref.value;
						minIndex = minind;
					}
				}
			}
			minind += 1;
			ref = ref.next;
		}
		return min;
	}
	
	public int maxNodeDiv3() {
		Node ref = head;
		int max = minNodeDiv3();
		int maxind = 0;
		while ( ref != null ) {
			if (( ref.value % 3 == 0 ) & ( ref.value > max )) {
				max = ref.value;
				maxIndex = maxind; 
			}
			maxind += 1;
			ref = ref.next;
		}
		return max;
	}
	
	public int minIndexNodeDiv3() {
		int minNum = minNodeDiv3();
		return minIndex;
	}
	
	public int maxIndexNodeDiv3() {
		int maxNum = maxNodeDiv3();
		return maxIndex;
	}
	
	public void revNodeDiv3() {
		int maxNum = maxNodeDiv3();
		int minNum = minNodeDiv3();
		Insert( minNum, maxIndex );
		Insert( maxNum, minIndex );
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
}

public class example16_v1 {
	public static void main( String[] args ) {
		Scanner in = new Scanner( System.in );
		ListF list = new ListF();
		System.out.print( "Введите количество значений: " );
		int n = in.nextInt();
		for ( int i = 0; i < n; i++ ) {
			System.out.print( "Введите число " + i + ": " );
			list.AddLast( in.nextInt());
		}
		
		System.out.println( "Исходный массив: " + list.toString());
		System.out.println( "Сумма чисел делящихся на 3: " + list.sumNodeDiv3());
		System.out.println( "Количество чисел делящихся на 3: " + list.colNodeDiv3());
		System.out.println( "Среднее значение среди чисел делящихся на 3: " + list.sredNodeDiv3());
		System.out.println( "Минимальное значение среди чисел делящихся на 3: " + list.minNodeDiv3());
		System.out.println( "Максимальное значение среди чисел делящихся на 3: " + list.maxNodeDiv3());
		System.out.println( "Индекс минимального значение среди чисел делящихся на 3: " + list.minIndexNodeDiv3());
		System.out.println( "Индекс максимального значение среди чисел делящихся на 3: " + list.maxIndexNodeDiv3());
		list.revNodeDiv3();
		System.out.println( "Минимальный и максимальный поменяны местами: " + list.toString());
	}
}