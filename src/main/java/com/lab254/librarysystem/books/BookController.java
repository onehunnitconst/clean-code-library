package com.lab254.librarysystem.books;

import com.lab254.librarysystem.books.domain.Book;
import com.lab254.librarysystem.books.dto.BookDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @PostMapping("/save")
    public String registerBook(
            @RequestParam("isbn") String isbn,
            @RequestParam("title") String title,
            @RequestParam("author") String author,
            @RequestParam("publisher") String publisher,
            Model model) {
        Book book = new Book();

        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);

        book = bookService.createBook(book);

        model.addAttribute("book", book);

        return "save-result";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.deleteBook(id);

        return "delete-result";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "book-register";
    }

    @GetMapping
    public String retrieveBookList(
            @PageableDefault(size=10) Pageable pageable,
            Model model,
            @CookieValue(name = "userId", required = false) String userId
    ) {
        if (userId == null) {
            return "redirect:/";
        }



        List<BookDto> books = bookService.findBooks(pageable);
        model.addAttribute("books", books);

        return "book-list";
    }

    @GetMapping("/{id}")
    public String retriveBook(@PathVariable Long id, Model model) {
        BookDto book = bookService.findBookById(id);

        model.addAttribute("book", book);

        return "book-info";
    }

    @GetMapping("/{id}/rent")
    public String rentBookPage(@PathVariable Long id, Model model) {
        BookDto book = bookService.findBookById(id);

        if (book.isRent()) {
            return "no-rent";
        }

        model.addAttribute("book", book);
        return "book-rent";
    }

    @PostMapping("/{id}/rent-confirm")
    public String rentBook(@CookieValue("userId") String userId, @PathVariable Long id, Model model) {
        Long uid = Long.parseLong(userId);
        try {
            bookService.rentBook(uid, id);
            return "rent-result";
        } catch (IllegalStateException e) {
            return "rent-failed";
        }



    }
}
