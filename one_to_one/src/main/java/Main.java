import Entity.Author;
import Entity.Book;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        //Create Book Object
        Book book=new Book();
        book.setIsbn("ISBN001");
        book.setName("Madoldoowa");
        book.setType("Traditional");

        Author author=new Author();
        author.setId("A001");
        author.setName("Martin Wickramasingha");
        author.setGender("male");
        author.setBook(book);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //Save Object to database
        session.persist(author);
        session.persist(book);

        transaction.commit();

        session.close();
    }
}
