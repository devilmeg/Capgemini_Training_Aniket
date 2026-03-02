package FunctionalInterface;
import java.util.function.Consumer;

//import static jdk.internal.org.jline.utils.Colors.s;

public class Consumers {
    public static void main(String[] args) {
//        Consumer<String>printer=name->System.out.println("Hello"+nameSystem.out.println("Hello"+name);
        Consumer<String>printer= System.out::println;
//        printer.accept("Aniket");
        System.out.println("null");



    }
}
