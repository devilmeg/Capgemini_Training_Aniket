import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    // 1. Intermediate methods : map , filter (aka lazy methods)
    // 2. Terminating methods : Eager , collect(collectors) , toList() , toSet().
    // 3. Short Circuiting methods :  skip() , skipFirst().

    public static void main(String[] args) {
        List<String> immutableList = Stream.of("red" , "green" , null , null).toList();
        // when you call toList() , then we can't add more elements to the list.
        System.out.println(immutableList);
//        immutableList.add("yellow"); // if we want to create immutable list we can directly go for toList()
        // here we can not add new element by using add().
        System.out.println("------------");

        List<String> mutableList = Stream.of("red" , "green" , null , null).collect(Collectors.toList());
        System.out.println(mutableList);
        mutableList.add("orange"); // if we use collect(Colletors.toList()) , it will be mutable so we do modification.
        mutableList.add("yellow");
        System.out.println("----------");

        // records are like class only but they are immutable and are light weight  , Data Transfer Objects.
        // Enums mein constructor nhi hota but records mein constructor hota hai.
        record Product(String name , String category , int price){

        }
        Stream<Product> products = Stream.of(new Product("bat" , "sportsitem" , 4000) ,
                new Product("bells" , "sportsitem" , 4000) ,
                new Product("ball" , "sportsitem" , 2000) ,
                new Product("mobile" , "sportsitem" , 14000),
                new Product("apple" , "fruit" , 200));

        // Grouping products by category
//        Map<String , List<Product>> categoryMap = products.collect(Collectors.groupingBy(Product :: category));
//        System.out.println(categoryMap);
        // comment out  category and run the next one.

        // Aggregating based on grouping
//        Map<String , Integer> pricing = products.collect(Collectors.groupingBy(Product :: category , Collectors.summingInt(Product :: price)));
//        System.out.println(pricing);

        // finding the avg of all categories prices(return type - double).
        Map<String , Double> avg = products.collect(Collectors.groupingBy(Product :: category , Collectors.averagingDouble(Product :: price)));
        System.out.println(avg);

        // Filtering
        List<Product>


    }
}
