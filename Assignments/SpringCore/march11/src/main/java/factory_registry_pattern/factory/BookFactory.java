package factory_registry_pattern.factory;
import factory_registry_pattern.bookservice.JavaBookService;
import factory_registry_pattern.bookservice.PythonBookService;
import factory_registry_pattern.bookservice.SpringBookService;
import factory_registry_pattern.interfacee.BookService;
import java.util.*;
public class BookFactory {
    private  Map<String,BookService>services;

    public void setServices(Map<String,BookService>services){
        this.services=services;
    }
    public  BookService getService(String type){
        return services.get(type);
    }
}
