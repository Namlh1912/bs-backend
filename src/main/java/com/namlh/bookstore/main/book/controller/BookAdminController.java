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
import com.namlh.bookstore.main.book.domain.usecase.FetchListBook.FetchListBook;
import com.namlh.bookstore.main.book.domain.usecase.FetchListBook.FetchListBookRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.POST)
    public Observable createBook(@RequestBody CreateBookRequest request) {
        return createBook.execute(request);
    }

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

    @RequestMapping(value = "/{bookId}" ,method =  RequestMethod.DELETE)
    public Observable deleteBook( @PathVariable(name = "bookId") Integer bookId){
        DeleteBookRequest request = new DeleteBookRequest();
        request.setBookId(bookId);
        return deleteBook.execute(request);
    }


//    @RequestMapping(
//            value = "/all",
//            method = RequestMethod.GET)
//    public Observable fetchListBook() {
//        return fetchListBook.execute(new FetchListBookRequest());
//    }

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
