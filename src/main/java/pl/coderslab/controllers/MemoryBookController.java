package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.resources.MemoryBookService;


@Controller
public class MemoryBookController {

    @Autowired
    private MemoryBookService memoryBookService;

    @GetMapping("/books")
    public String viewList(Model model){
        if (memoryBookService.getBooks().isEmpty()){
            memoryBookService.addBooks();
            model.addAttribute("books", memoryBookService.getBooks());
            return "showBooks";
        }

        else {
            model.addAttribute("books", memoryBookService.getBooks());
            return "showBooks";
        }
    }

    @GetMapping("/books/{id:\\d+}")
    public String showBook (@PathVariable Long id, Model model){
        model.addAttribute("book", memoryBookService.showBook(id));
        return "showBook";
    }

    @PostMapping("/books")
    public String addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type){
        memoryBookService.addBook(isbn, title, author, publisher, type);
        return "redirect:books";
    }

}
