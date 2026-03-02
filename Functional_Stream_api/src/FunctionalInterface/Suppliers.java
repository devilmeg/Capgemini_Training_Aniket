package FunctionalInterface;

import java.util.Random;
import java.util.function.Supplier;

public class Suppliers {
    public static void main(String[] args) {
        Supplier<Double> randomValue=()->Math.random();
        System.out.println(randomValue.get());
        System.out.println();

        Supplier<Integer>otp=()->new Random().nextInt(9000)+1000;

        System.out.println("Genrated OTP: "+otp.get());
    }
}
