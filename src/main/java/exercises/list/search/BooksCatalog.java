package main.java.exercises.list.search;

import java.util.ArrayList;
import java.util.List;

public class BooksCatalog {
    // attribute
    private List<Book> bookList;

    public BooksCatalog() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(String title, String author, int yearPublished) {
        bookList.add(new Book(title, author,yearPublished));
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> bookByAuthor = new ArrayList<>();
        if (!bookList.isEmpty()) {
            for (Book b : bookList) {
                if (b.getAuthor().equalsIgnoreCase(author)) {
                    bookByAuthor.add(b);
                }
            }
            return bookByAuthor;
        } else {
            throw new RuntimeException("The list is empty!!");
        }
    }

    public List<Book> searchByIntervalYears(int initialYear, int finalYear) {
        List<Book> booksByIntervalYears = new ArrayList<>();
        if (!bookList.isEmpty()) {
            for (Book b : bookList) {
                if (b.getYearPublished() >= initialYear && b.getYearPublished() <= finalYear) {
                    booksByIntervalYears.add(b);
                }
            }
            return booksByIntervalYears;
        } else {
            throw new RuntimeException("The list is empty!!");
        }
    }

    public Book searchByTitle(String title) {
        Book bookByTitle = null;
        if (!bookList.isEmpty()) {
            for (Book b : bookList) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    bookByTitle = b;
                    break;
                }
            }
            return bookByTitle;
        } else {
            throw new RuntimeException("The list is empty!!");
        }
    }

    public static void main(String[] args) {
        // Creating a Book Catalog Instance
        BooksCatalog booksCatalog = new BooksCatalog();

        //Adding books to the catalog
        booksCatalog.addBook("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        booksCatalog.addBook("Java Guia do Programador", "Peter Jandl Junior", 2021);
        booksCatalog.addBook("Código Limpo", "Robert C. Martin", 2009);
        booksCatalog.addBook("O Codificador Limpo", "Robert C. Martin", 2012);

        // Showing books by the same author Showing books by the same author
        System.out.println(booksCatalog.searchByAuthor("Robert C. Martin"));

        // Displaying books by the same author (in which case there are no books by a specific author)
        System.out.println(booksCatalog.searchByAuthor("Autor Inexistente"));

        // Displaying books within a range of years
        System.out.println(booksCatalog.searchByIntervalYears(2010,2025));

        // Displaying books within a range of years (in which case there are no books in the range)
        System.out.println(booksCatalog.searchByIntervalYears(2025,2035));

        // Displaying books by title
        System.out.println(booksCatalog.searchByTitle("Java Guia do Programador"));

        // Displaying books by title (in which case there are no books with the specified title)
        System.out.println(booksCatalog.searchByTitle("Título Inexistente"));
    }
}
