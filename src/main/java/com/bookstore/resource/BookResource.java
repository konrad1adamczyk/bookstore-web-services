package com.bookstore.resource;

import com.bookstore.domain.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

@RestController
@RequestMapping("/book")
public class BookResource {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Book addBookPost(@RequestBody Book book) {
        return bookService.save(book);
    }

    @RequestMapping(value = "/add/image", method = RequestMethod.POST)
    public ResponseEntity<String> upload(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request) {
        try {
            Book book = bookService.findOne(id);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipartFile = multipartRequest.getFile(it.next());
            String fileName = id + ".png";

            byte[] bytes = multipartFile.getBytes();

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/" + fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity<>("Upload Success!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }
}
