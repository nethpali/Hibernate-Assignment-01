import Entity.Author;
import Entity.Book;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book=new Book();
        book.setIsbn("ISBN004");
        book.setName("Jane");
        book.setType("Fictional");

        Book book1=new Book();
        book1.setIsbn("ISBN005");
        book1.setName("Juliana");
        book1.setType("Children");

        Author author=new Author();
        author.setId("A002");
        author.setName("J.K.Rolling");
        author.setGender("Male");


        List<Book> books=new ArrayList<>();
        books.add(book);
        books.add(book1);

        author.setBookList(books);
        book.setAuthor(author);
        book1.setAuthor(author);


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(book1);
        session.persist(author);

        transaction.commit();
        session.close();
    }
}
