package com.namlh.bookstore.main.book.controller;

import com.namlh.bookstore.main.book.domain.usecase.CreateAuthor.CreateAuthor;
import com.namlh.bookstore.main.book.domain.usecase.CreateAuthor.CreateAuthorRequest;
import com.namlh.bookstore.main.book.domain.usecase.CreateBook.CreateBook;
import com.namlh.bookstore.main.book.domain.usecase.CreateBook.CreateBookRequest;
import com.namlh.bookstore.main.book.domain.usecase.CreateCategory.CreateCategory;
import com.namlh.bookstore.main.book.domain.usecase.CreateCategory.CreateCategoryRequest;
import com.namlh.bookstore.main.book.domain.usecase.CreatePublisher.CreatePublisher;
import com.namlh.bookstore.main.book.domain.usecase.CreatePublisher.CreatePublisherRequest;
import com.namlh.bookstore.main.book.domain.usecase.DeleteBook.DeleteBook;
import com.namlh.bookstore.main.book.domain.usecase.DeleteBook.DeleteBookRequest;
import com.namlh.bookstore.main.book.domain.usecase.EditBook.EditBook;
import com.namlh.bookstore.main.book.domain.usecase.EditBook.EditBookRequest;
import com.namlh.bookstore.main.book.domain.usecase.EditBook.EditBookResponse;
import com.namlh.bookstore.main.book.domain.usecase.FetchListBook.FetchListBook;
import com.namlh.bookstore.main.book.domain.usecase.FetchListBook.FetchListBookRequest;
import com.namlh.bookstore.main.book.domain.usecase.ReadBookById.ReadBookById;
import com.namlh.bookstore.main.book.domain.usecase.ReadBookById.ReadBookByIdRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.namlh.bookstore.utils.Params.DEFAULT_LIMIT;

/**
 * Created by app on 7/18/18.
 */
@RestController
@RequestMapping(Params.ADMIN_PATH + Params.BOOK_PATH)
public class BookAdminController {

    @Autowired
    private FetchListBook fetchListBook;

    @Autowired
    private CreateAuthor createAuthor;

    @Autowired
    private CreatePublisher createPublisher;

    @Autowired
    private CreateCategory createCategory;

    @Autowired
    private CreateBook createBook;

    @Autowired
    private DeleteBook deleteBook;

    @Autowired
    private EditBook editBook;

    @Autowired
    private ReadBookById readBookById;

    //Create book
    @RequestMapping(method = RequestMethod.POST)
    public Observable createBook(@RequestBody CreateBookRequest request) {
        return createBook.execute(request);
    }

    //List book
    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    public Observable retrieveAllRecentBook(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "limit", required = false) Integer limit) {
        FetchListBookRequest request = new FetchListBookRequest();
        request.setPage(page == null ? 1 : page);
        request.setLimit(limit == null ? DEFAULT_LIMIT : limit);
        return fetchListBook.execute(request);
    }

    //Delete book
    @RequestMapping(value = "/{bookId}" ,method =  RequestMethod.DELETE)
    public Observable deleteBook(@PathVariable(name = "bookId") Integer bookId){
        DeleteBookRequest request = new DeleteBookRequest();
        request.setBookId(bookId);
        return deleteBook.execute(request);
    }

    //Edit book
    @RequestMapping(value="/{bookId}", method = RequestMethod.PUT)
    public Observable editBook(
            @RequestBody EditBookRequest request,
            @PathVariable(name = "bookId") Integer bookId){
        request.setBookId(bookId);
        return editBook.execute(request);
    }

    //Book detail
    @RequestMapping(
            value = "/{bookId}", method = RequestMethod.GET)
    @PreAuthorize("@permissionChecker.checkCurrentUserIsAdmin()")
    public Observable readBookInfo(@PathVariable("bookId") Integer bookId) {
        return readBookById.execute(new ReadBookByIdRequest(bookId));
    }

    @RequestMapping(
            value = "/author",
            method = RequestMethod.POST)
    public Observable createAuthor(@RequestBody CreateAuthorRequest request) {
        return createAuthor.execute(request);
    }

    @RequestMapping(
            value = "/publisher",
            method = RequestMethod.POST)
    public Observable createPublisher(@RequestBody CreatePublisherRequest request) {
        return createPublisher.execute(request);
    }

    @RequestMapping(
            value = "/category",
            method = RequestMethod.POST)
    public Observable createCategory(@RequestBody CreateCategoryRequest request) {
        return createCategory.execute(request);
    }
}
