package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;
@Entity
public class Book {
    @Id
    private String isbn;
    private String name;
    private String type;

    @ManyToMany
    private List<Author> authorList;

    public Book(String isbn, String name, String type, List<Author> authorList) {
        this.isbn = isbn;
        this.name = name;
        this.type = type;
        this.authorList = authorList;
    }

    public Book() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", authorList=" + authorList +
                '}';
    }
}
