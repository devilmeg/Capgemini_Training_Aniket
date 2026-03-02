package FunctionalInterface;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
public class Testpredicate {
    public static void main(String[] args) {
        Predicate<Integer>p=n->n>10;
        System.out.println(p.test(12));
        System.out.println(p.test(9));
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer>greaterThanThe=n->n%2==0;

        list.stream().filter(greaterThanThe).forEach((System.out::print));

        //Both condition
        Predicate<Integer>greaterThanOrEqualToTen=n->n>=10;
        Predicate<Integer>even=n->n%2==0;

        Predicate<Integer>res=greaterThanOrEqualToTen.and(even);

        System.out.println(res.test(12));
        List<String> names = Arrays.asList("Aniket", "Rahul", "Aman", "Priya");

        Predicate<String> startsWithA = name -> name.startsWith("A");

        names.stream()
                .filter(startsWithA)
                .forEach(System.out::println);

    }
}
