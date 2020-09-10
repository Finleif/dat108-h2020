package no.hvl.dat108.f07;

public class Eksempel4_dropp {
	
	public static void main(String[] args) {
		
		//Lage en runnable som sier Hallo
		//Lage og kjøre 2 tråder med denne runnable-en
		//Skulle ønske at de to trådene også skriver ut tråd-id-en.
		
		Runnable r = () -> {
			String navn = Thread.currentThread().getName();
			System.out.println("Hallo fra " + navn);
		};
		
		new Thread(r, "T1").start();
		new Thread(r, "T2").start();
		
		//Men fikk ikke demonstrert det jeg hadde tenkt. Hmmm ....?
	}
		
}
