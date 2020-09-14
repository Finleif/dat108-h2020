package no.hvl.dat108.f07;
/* Kopiert fra javabrains.io sitt Java 8 Lambda Basics kurs */

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//interface Betingelse {
//    boolean erSant(Person p);
//}

public class Eksempel2_Oppgave {

    static void printAll(List<Person> listen) {
        doConditionally(listen, p -> true, System.out::println);
    }

    static void printLastNAmeStartsWith(List<Person> listen) {
        for (Person p : listen) {
            if (p.getLastName().startsWith("C")) {
                System.out.println(p);
            }
        }
    }

    static void printConditionally(List<Person> listen, Predicate<Person> pred) {
  //      doConditionally(listen, pred, p -> System.out::println);
    }

    static void doConditionally(List<Person> listen, Predicate<Person> b, Consumer<Person> consumer) {
        for (Person p : listen) {
            if (b.test(p)) {
                System.out.println(p);
                consumer.accept(p);
            }
        }
    }

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // 1: Sorter personene på etternavn.
        Collections.sort(people, (a, b) -> a.getLastName().compareTo(b.getLastName()));

        // 2: Skriv ut alle personene, én linje per person.
        // 		Lag en egen hjelpemetode printAll(...) som gjør dette.
        //  printAll(people);
        doConditionally(people, p -> true, p -> System.out.println(p));

        // 3: Skriv ut alle personene som har etternavn som begynner på C.
        //		Lag en egen hjelpemetode printLastNameStartsWithC(...) som gjør dette.
        //   printLastNAmeStartsWith(people);
// ta selv

        // 4: Skriv ut alle personene som har fornavn som begynner på C.
        //		Vi ser nå at det er tungvint å lage én utskriftsmetode per
        //      spesialtilfelle. Lag en generell hjelpemetode printConditionally(...)
        //		gjør jobben i stedet. Denne tar inn listen + et lambdauttrykk.
        //  printConditionally(people, p -> p.getFirstName().startsWith("C"));
        //   doConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p));

        // 5: Skriv ut ALLE personene ved å bruke printConditionally(...)
        //   printConditionally(people, p -> true);
        doConditionally(people, p -> true, p -> System.out.println(p));
    }
}
