package factory_registry_pattern.bookservice;
import factory_registry_pattern.interfacee.*;
public class JavaBookService  implements BookService {
    @Override
    public void readBook(){
        System.out.println("Java....");
    }
}
