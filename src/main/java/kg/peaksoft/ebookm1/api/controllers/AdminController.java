package kg.peaksoft.ebookm1.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoft.ebookm1.api.payloads.dto.book.BookResponse;
import kg.peaksoft.ebookm1.api.payloads.dto.vendor.VendorResponse;
import kg.peaksoft.ebookm1.services.BookService;
import kg.peaksoft.ebookm1.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Admin", description = "The Admin API")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
@RequestMapping("/api/admin")
public class AdminController {

    private final VendorService vendorService;
    private final BookService bookService;

    // Vendors
    @Operation(summary = "Method all vendors", description = "Admin to get all VENDORS from the database")
    @GetMapping("/vendors")
    public List<VendorResponse> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @Operation(summary = "Vendor's book count method", description = "Admin can to get all VENDOR'S count books from the database")
    @GetMapping("/count-books/{vendorId}")
    public String countBooks(@PathVariable Long vendorId) {
        return bookService.countBooks(vendorId);
    }

    @Operation(summary = "Method delete by id", description = "User with role ADMIN and VENDOR can deleted")
    @DeleteMapping("/vendor/{vendorId}")
    public ResponseEntity<String> deleteById(@PathVariable Long vendorId) {
        vendorService.deleteById(vendorId);
        return new ResponseEntity<>("Successfully removed vendor by id: " + vendorId, HttpStatus.OK);
    }

    // Books
    @Operation(summary = "Method get all vendor books", description = "Admin can to get all VENDOR'S books from the database")
    @GetMapping("/vendor-books/{vendorId}")
    public List<BookResponse> getAllVendorBooks(@PathVariable Long vendorId) {
        return bookService.getAllVendorBooks(vendorId);
    }
}