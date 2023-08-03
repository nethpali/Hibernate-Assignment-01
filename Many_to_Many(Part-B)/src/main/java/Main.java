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
        book.setIsbn("ISBN001");
        book.setName("Her");
        book.setType("Fictional");

        Book book1=new Book();
        book1.setIsbn("ISBN002");
        book1.setName("Him");
        book1.setType("novel");

        Author author=new Author();
        author.setId("A001");
        author.setName("John");
        author.setGender("Male");

        Author author1=new Author();
        author1.setId("A002");
        author1.setName("Kate");
        author1.setGender("Female");

        List<Book> bookList=new ArrayList<>();
        bookList.add(book);
        bookList.add(book1);

        List<Author> authorList=new ArrayList<>();
        authorList.add(author);
        authorList.add(author1);

        book.setAuthorList(authorList);
        book1.setAuthorList(authorList);

        author.setBookList(bookList);
        author1.setBookList(bookList);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        session.persist(book1);
        session.persist(author);
        session.persist(author1);

        transaction.commit();
        session.close();
    }
}
