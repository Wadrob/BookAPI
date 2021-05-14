package pl.coderslab.resources;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService {
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "MemoryBookService{" +
                "books=" + books +
                '}';
    }

    public void addBooks() {
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "2222221321446", "Sapiens", "Yalom Harari", "WAB", "history"));
        books.add(new Book(3L, "9788321241446", "Słowo Światłości", "Bruce Sanderson", "MAG", "fantasy"));
        books.add(new Book(4L, "9312312312316", "Thinking in Java 2", "Bruce Eckel", "Helion", "programming"));
    }

    public Book showBook(Long id){
        Book bookToshow = null;
        for (Book book : books){
            if (book.getId() == id){
                bookToshow = book;
            }
        }
        return bookToshow;
    }

    public void addBook(String isbn, String title, String author, String publisher, String type){
        Long id = Long.valueOf(books.size() +1);
        books.add(new Book(id, isbn, title, author, publisher, type));
    }


}
