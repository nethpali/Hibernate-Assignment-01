import Entity.Book;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Create new Object in book type
        Book book=new Book();
        book.setIsbn("ISBN001");
        book.setName("Village ");
        book.setType("Traditional");


        Book book1=new Book();
        book1.setIsbn("ISBN002");
        book1.setName("The sea");
        book1.setType("Traditional");


        Book book2=new Book();
        book2.setIsbn("ISBN003");
        book2.setName("Village By the sea");
        book2.setType("Gamperaliya");

        //Get the Hibernate session instance from the factory configuration
        Session session = FactoryConfiguration.getInstance().getSession();
        //Begin a new transaction
        Transaction transaction = session.beginTransaction();

        //Save the book object to the database
        session.persist(book);
        session.persist(book1);
        session.persist(book2);

        //commit the transaction
        transaction.commit();
        session.close();
        searchId();
        updateBook();
        DeleteBook();

    }

    //Search the book object from database
    public static void searchId(){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter Book ISBN :");
        String isbn=input.nextLine();

        // new Book(isbn);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book book=session.get(Book.class,isbn);
        System.out.println(book.toString());
        transaction.commit();
        session.close();


    }

    //Update the book object from database
    public static void updateBook(){

        System.out.println("Update Book");
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.load(Book.class, "ISBN001");
        book.setType("Fictional");
        session.update(book);
        System.out.println(book);
        transaction.commit();
        session.close();

    }

    //Delete the book Object from database
    public static void DeleteBook(){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter Book ISBN :");
        String isbn=input.nextLine();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        Book book=session.get(Book.class,isbn);
        session.remove(book);
        System.out.println(book);
        transaction.commit();
        session.close();


    }
}
