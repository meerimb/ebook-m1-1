package kg.peaksoft.ebookm1.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoft.ebookm1.api.controllers.payloads.dto.book.BookResponseView;
import kg.peaksoft.ebookm1.db.entities.book.Book;
import kg.peaksoft.ebookm1.db.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
@Tag(name = "Book", description = "The Book API")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class BookController {

    private final BookService bookService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_VENDOR','ROLE_CLIENT')")
    @Operation(summary = "Allows to search all books from the database")
    @GetMapping("/search")
    public BookResponseView searchAndPagination(@RequestParam(name = "name", required = false)
                                                        String name, @RequestParam int page) {
        return bookService.searchAndPagination(name, page - 1);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_VENDOR','ROLE_CLIENT')")
    @Operation(summary = "Allows to sort all books from the database")
    @GetMapping( "/sort/{pageNumber}/{pageSize}/{sortProperty}")
    public Page<Book> sortAndPagination(@PathVariable Integer pageNumber,
                                     @PathVariable Integer pageSize,
                                     @PathVariable String sortProperty) {
        return bookService.sortAndPagination(pageNumber, pageSize, sortProperty);
    }
}
