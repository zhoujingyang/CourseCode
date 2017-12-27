package tester.test;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zjy on 17/5/26.
 */

public class Application {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("no lambda");
            }
        }).start();

        new Thread( () -> System.out.println("lambda") ).start();

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(f -> System.out.println(f));
        features.forEach(System.out::println);


        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("===================");

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

    }

    public static void filter(List names, Predicate condition) {
        for(Object name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
}
