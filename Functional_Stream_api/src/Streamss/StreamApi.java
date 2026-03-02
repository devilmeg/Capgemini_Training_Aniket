package Streamss;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {

        // Mutable list using collect()
        List<String> mutableList =
                Stream.of("red", "green", null, null)
                        .collect(Collectors.toList());

        System.out.println("Before modification: " + mutableList);

        // Now modification works
        mutableList.add("Orange");
        mutableList.add(2, "Yellow");

        System.out.println("After modification: " + mutableList);

        System.out.println("************************************");

        // If you want immutable list
        List<String> immutableList =
                Stream.of("red", "green", null, null)
                        .toList();

        System.out.println("Immutable list: " + immutableList);

        // immutableList.add("Blue"); // ❌ will throw exception

        record Product(String name,String category,int price){}
        Stream<Product> products=Stream.of(new Product("bat","sportItem",4500),
                new Product("bells","sport",1000),new Product("balls","sportItem",2000),new Product("mobile","Item",20000));


        ///Grouping products by category
//        Map<String,List<Product>> catgeoryMap=products.collect(Collectors.groupingBy(Product::category));
//        System.out.println("catgeoryMap: " + catgeoryMap);

        System.out.println("*********************************");

        //Aggreagatre based on grouping
//        Map<String,Integer> pricing=products.collect(Collectors.groupingBy(Product::category,Collectors.summingInt(Product::price)));
//        System.out.println(pricing);
//        Map<String,Double> avgpricing=products.collect(Collectors.groupingBy(Product::category,Collectors.averagingDouble(Product::price)));
//        System.out.println(avgpricing);


        //filter
//        List<Product>filteredProducts=products.filter(p->p.price>2500).collect(Collectors.toList());
//        System.out.println("filteredProducts: " + filteredProducts);
        List<String>filteredProducts=products.filter(p->p.price>2500)
                .map(p->p.name).
                collect(Collectors.toList());
        System.out.println("filteredProducts: " + filteredProducts);

    }
}