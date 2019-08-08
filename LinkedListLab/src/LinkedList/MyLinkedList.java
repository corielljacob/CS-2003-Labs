package LinkedList;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyLinkedList {
	public static void main(String[] args) {
		LinkedList<String> list1 = new  LinkedList<String>();
		LinkedList<String> list2 = new  LinkedList<String>();
		
		list1.add("Tulsa");
		list1.add("Ada");
		list1.add("Broken Arrow");
		list1.add("Owasso");
		
		list1.add(1, "OKC");
		
		list2.add("74104");
		list2.add("74135");
		list2.add("foo");
		list2.add("hello world");
		list2.add("777");
		
		
		ListIterator<String> iter = list1.listIterator();
		ListIterator<String> iter2 = list2.listIterator();
		
		while(iter.hasNext()) {
			iter.next();
			iter.add(iter2.next());
		}
		
		
		ListIterator<String> iter3 = list1.listIterator();
		iter3.next();
		
		while(iter3.hasNext()) {
			iter3.next();
			iter3.remove();
			if(iter3.hasNext())
				iter3.next();
		}
	
		
		LinkedList<String> copiedList2 = new LinkedList<String>();
		ListIterator<String> iter4 = list2.listIterator();
		
		while(iter4.hasNext()) {
			copiedList2.add(iter4.next());
		}
	
	}
}
