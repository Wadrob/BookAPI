package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.resources.Book;
import pl.coderslab.resources.MemoryBookService;

import java.util.List;


@Controller
public class MemoryBookController {

    @Autowired
    private MemoryBookService memoryBookService;

    @GetMapping("/books")
    @ResponseBody
    public List <Book> viewList(Model model){
        if (memoryBookService.getBooks().isEmpty()){
            memoryBookService.addBooks();
            return memoryBookService.getBooks();
        }

        else {
            return memoryBookService.getBooks();
        }
    }

    @GetMapping("/books/{id:\\d+}")
    @ResponseBody
    public Book showBook (@PathVariable Long id){
        return memoryBookService.showBook(id);
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Book book){
        memoryBookService.addBook(book);
        return "redirect:books";
    }

    @PutMapping("/books")
    public String changeBook(@RequestBody Book book){
        memoryBookService.changeBook(book);
        return "redirect:books";
    }

    @DeleteMapping("/books/{id:\\d+}")
    public String removeBook(@PathVariable Long id){
        memoryBookService.removeBook(id);
        return "redirect:books";
    }



}
