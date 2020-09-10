package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;

public class F06aBoble {
	
	private static <T extends Comparable<T>> void sorter(List<T> listen) {
//		sorter(listen, (a,b) -> a.compareTo(b));
//evt.
		sorter(listen, T::compareTo);
	}

	private static <T extends Comparable<T>> void sorter(List<T> listen, Sammenligner<T> s) {
		for (int i=0; i<listen.size(); i++) {
			for (int j=1; j<listen.size(); j++) {
				T a = listen.get(j-1);
				T b = listen.get(j);
				if (s.sammenlign(a, b) > 0) {
					listen.set(j-1, b);
					listen.set(j, a);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		List<Integer> listeAvTall = Arrays.asList(4,2,7,5,9,1);
		sorter(listeAvTall);
		System.out.println(listeAvTall);

		List<String> listeAvString = Arrays.asList("Aaa", "Xxx", "Bbb", "Kkk");
		sorter(listeAvString);
		System.out.println(listeAvString);
		
		List<Person> listeAvPersoner = Arrays.asList(
				new Person("Anne", "Persen"), new Person("Per", "Andersen"),
				new Person("Knut", "Svendsen"));
		sorter(listeAvPersoner);
		System.out.println(listeAvPersoner);
		
		//Jeg ønsker å sortere personene på fornavn! Hva gjør vi???
		Sammenligner<Person> s = new FornavnSammenligner();
		sorter(listeAvPersoner, s);
		System.out.println(listeAvPersoner);
		
		//Sortere på fødselsår
//		sorter(listeAvPersoner, new Sammenligner<Person>() {
//			@Override
//			public int sammenlign(Person a, Person b) {
//				// kode for å sammenligne alder ...
//			}
//		});
//		System.out.println(listeAvPersoner);
	}
}



