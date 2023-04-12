package beans;

import java.math.BigInteger;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private BigInteger isbn;
    private int publicationYear;

    public Book(String title, String author, BigInteger isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn) && Objects.equals(publicationYear, book.publicationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn, publicationYear);
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d", title, author, isbn.toString(), publicationYear);
    }

    public String toStringForFile() {
        return String.format("%s,%s,%s,%d", title, author, isbn.toString(), publicationYear);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}