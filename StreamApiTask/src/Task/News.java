package Task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class News {
    public static int findSecondHighestSalary(int[] arr){
        return Arrays.stream(arr).distinct().boxed()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
    }


    public void main(String[] args){
        int arr[]={10,20,5,20,8};
        System.out.println(findSecondHighestSalary(arr));

        System.out.println("****************");
        Map<Integer,Long> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        num->num,Collectors.counting()
                ));
        map.forEach((key,value)->
                System.out.println(key+","+value));

    }
}
