package CollectionProject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShirtService {
private List<Shirt> shirts=new ArrayList<>();
//b Design a method add shirts
    public void addShirt(Shirt s){
        shirts.add(s);
    }
//c Access All shirts
    public List<Shirt>getAllShirts(){
        return shirts;
    }
    //d.By brand
    public List<Shirt>getBrand(String brand){
        return shirts.stream().filter(s->s.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    //e. Design a method to Access all shirts by brand and size
    public List<Shirt>getByBrandAndSize(String Brand,int size){
        return shirts.stream().filter(s->s.getBrand().equalsIgnoreCase(Brand)&& s.getSize()==size)
                .collect(Collectors.toList());

    }
    // f.Design a method to Access all shirts in a price range

    public List<Shirt>getByPriceRange(double min,double max){
        return shirts.stream().filter(s->s.getPrice()>=min && s.getPrice()<=max).collect(Collectors.toList());
    }
    //g. Design a method to Access all shirts by size and price
    //range
    public List<Shirt>getByPriceRange(double min,double max,int size){
        return shirts.stream().filter(s->s.getSize()==size
        && s.getPrice()>=min && s.getPrice()<=max).collect(Collectors.toList());
    }
    //h Design a method to Sort all shirts on size low to high
    public List<Shirt>sortSizeAsc(){
        return shirts.stream().sorted(Comparator.comparingInt(Shirt::getSize)).collect(Collectors.toList());
    }
    //i Design a method to Sort all shirts on size high to low
    public List<Shirt>sortSizeDesc(){
        return shirts.stream().sorted(Comparator.comparingInt(Shirt::getSize).reversed()).collect(Collectors.toList());
    }

    //jDesign a method to Sort all shirts on price low to high
    public List<Shirt>sortPriceAsc(){
        return shirts.stream()
                .sorted(Comparator.comparingDouble(Shirt::getPrice)).collect(Collectors.toList());
    }
//x.

    public Map<String,Long> countEachBrand(){
        return shirts.stream().collect(Collectors
                .groupingBy(Shirt::getBrand,Collectors.counting()));
    }

}
