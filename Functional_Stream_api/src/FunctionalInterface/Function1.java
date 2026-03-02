package FunctionalInterface;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
public class Function1 {
    public static void main(String[] args) {
        Function<Integer,Integer>sq=n->n*n;
        System.out.println(sq.apply(10));

        List<String> names= Arrays.asList("A","B","C");

//        Function<String,String>tolower=(s)->s.toLowerCase();
        Function<String,String>tolower=String::toLowerCase;
        names.stream().map(tolower).forEach(System.out::println);

    }
}
