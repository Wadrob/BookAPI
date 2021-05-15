package pl.coderslab.resources;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void addBook(Book book){
        book.setId(Long.valueOf(books.size() +1));
        books.add(book);
    }

    public void changeBook(Book book){
        Optional <Long> optional = Optional.ofNullable(book.getId());
        if (optional.isPresent()){
            if (book.getId()<books.size()){
                for (Book book1 : books){
                    if (book1.getId() == book.getId()){
                        book1.setAuthor(book.getAuthor());
                        book1.setIsbn(book.getIsbn());
                        book1.setPublisher(book.getPublisher());
                        book1.setTitle(book.getTitle());
                        book1.setType(book.getType());
                    }
                }
            }
        }
    }

    public void removeBook(Long id){
        Optional <Long> optional = Optional.ofNullable(id);
        if(optional.isPresent()){
            books.removeIf(book -> book.getId() == id);
        }
    }
}
