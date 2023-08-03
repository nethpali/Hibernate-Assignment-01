import Entity.Book;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        session.persist(book1);
        session.persist(book2);
        transaction.commit();
        session.close();
        searchId();
        updateBook();
        DeleteBook();

    }
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
