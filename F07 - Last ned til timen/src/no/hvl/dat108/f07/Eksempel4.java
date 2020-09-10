package no.hvl.dat108.f07;

public class Eksempel4 {

    public static void main(String[] args) {

        Runnable r = () -> {
            String navn = Thread.currentThread().getName();
            System.out.println("Hallo fra " + navn);
        };

        new Thread(r, "T1").start();
        new Thread(r, "T2").start();

//        new Thread(() -> System.out.println("Hallo").start();
//        new Thread(() -> System.out.println("Hallo").start();

        //Lage en runnable som sier Hallo
        //Lage og kjøre 2 tråder med denne runnable-en
        //Skulle ønske at de to trådene også skriver ut tråd-id-en.
    }

}
