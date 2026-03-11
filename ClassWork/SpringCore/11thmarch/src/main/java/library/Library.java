package library;
import java.util.List;

public class Library {
    private List<Book>books;

    public void setBooks(List<Book>b){
        this.books=b;
    }
    public void showBooks(){
        System.out.println("Library Books");
        for(Book b:books){
            System.out.println(b);
        }
    }
}
