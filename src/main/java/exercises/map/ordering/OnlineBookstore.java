package main.java.exercises.map.ordering;

import java.util.*;

public class OnlineBookstore {
    //
    private Map<String, Book> books;

    public OnlineBookstore() {
        this.books = new HashMap<>();
    }

    public void addBook(String link, Book book) {
        books.put(link, book);
    }

    public void removeBook(String title) {
        List<String> keyRemove = new ArrayList<>();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                keyRemove.add(entry.getKey());
            }
        }
        for (String key : keyRemove) {
            books.remove(key);
        }
    }

    public Map<String, Book> displayBooksOrderedByPrice() {
        List<Map.Entry<String, Book>> booksToOrderByPrice = new ArrayList<>(books.entrySet());

        Collections.sort(booksToOrderByPrice, new ComparatorByPrice());

        Map<String, Book> booksSortedByPrice = new LinkedHashMap<>();

        for (Map.Entry<String, Book> entry : booksToOrderByPrice) {
            booksSortedByPrice.put(entry.getKey(), entry.getValue());
        }

        return booksSortedByPrice;
    }

    public Map<String, Book> displayBooksOrderedByAuthor() {
        List<Map.Entry<String, Book>> booksToOrderByAuthor = new ArrayList<>(books.entrySet());

        Collections.sort(booksToOrderByAuthor, new ComparatorByAuthor());

        Map<String, Book> booksOrderedByAuthor = new LinkedHashMap<>();

        for (Map.Entry<String, Book> entry : booksToOrderByAuthor) {
            booksOrderedByAuthor.put(entry.getKey(), entry.getValue());
        }

        return booksOrderedByAuthor;
    }

    public Map<String, Book> searchBooksByAuthor(String autor) {
        Map<String, Book> booksByAuthor = new LinkedHashMap<>();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            Book book = entry.getValue();
            if (book.getAuthor().equals(autor)) {
                booksByAuthor.put(entry.getKey(), book);
            }
        }
        return booksByAuthor;
    }

    public List<Book> getMoreExpensiveBook() {
        List<Book> MostExpensivebooks = new ArrayList<>();
        double priceHighest = Double.MIN_VALUE;

        if (!books.isEmpty()) {
            for (Book book : books.values()) {
                if (book.getPrice() > priceHighest) {
                    priceHighest = book.getPrice();
                }
            }
        } else {
            throw new NoSuchElementException("The bookstore is empty!");
        }

        for(Map.Entry<String, Book> entry: books.entrySet()) {
            if(entry.getValue().getPrice() == priceHighest) {
                Book bookWithTheHighestPrice = books.get(entry.getKey());
                MostExpensivebooks.add(bookWithTheHighestPrice);
            }
        }
        return MostExpensivebooks;
    }

    public List<Book> getCheaperBook() {
        List<Book> cheapestbooks = new ArrayList<>();
        double lowerprice = Double.MAX_VALUE;

        if (!books.isEmpty()) {
            for (Book livro : books.values()) {
                if (livro.getPrice() < lowerprice) {
                    lowerprice = livro.getPrice();
                }
            }
        } else {
            throw new NoSuchElementException("The bookstore is empty!");
        }

        for(Map.Entry<String, Book> entry: books.entrySet()) {
            if(entry.getValue().getPrice() == lowerprice) {
                Book bookWithPriceLow = books.get(entry.getKey());
                cheapestbooks.add(bookWithPriceLow);
            }
        }
        return cheapestbooks;
    }

    public static void main(String[] args) {
        OnlineBookstore onlineBookstore = new OnlineBookstore();
        // Add books to the online bookstore
        onlineBookstore.addBook("https://amzn.to/3EclT8Z", new Book("1984", "George Orwell", 50d));
        onlineBookstore.addBook("https://amzn.to/47Umiun", new Book("A Revolução dos Bichos", "George Orwell", 7.05d));
        onlineBookstore.addBook("https://amzn.to/3L1FFI6", new Book("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        onlineBookstore.addBook("https://amzn.to/3OYb9jk", new Book("Malorie", "Josh Malerman", 5d));
        onlineBookstore.addBook("https://amzn.to/45HQE1L", new Book("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        onlineBookstore.addBook("https://amzn.to/45u86q4", new Book("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Displays all books sorted by price
        System.out.println("Books sorted by price: \n" + onlineBookstore.displayBooksOrderedByPrice());

        // Displays all books sorted by author
        System.out.println("Books sorted by author: \n" + onlineBookstore.displayBooksOrderedByAuthor());

        // Search books by author
        String authorSearch = "Josh Malerman";
        onlineBookstore.searchBooksByAuthor(authorSearch);

        // Get and display the most expensive book
        System.out.println("Most expensive book: " + onlineBookstore.getMoreExpensiveBook());

        // Gets and displays the cheapest book
        System.out.println("Cheapest book: " + onlineBookstore.getCheaperBook());

        // Remove a book by title
        onlineBookstore.removeBook("1984");
        System.out.println(onlineBookstore.books);

    }

}
