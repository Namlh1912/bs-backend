package com.namlh.bookstore.main.book.controller;

import com.namlh.bookstore.main.book.domain.usecase.CreateAuthor.CreateAuthor;
import com.namlh.bookstore.main.book.domain.usecase.CreateAuthor.CreateAuthorRequest;
import com.namlh.bookstore.main.book.domain.usecase.CreateBook.CreateBook;
import com.namlh.bookstore.main.book.domain.usecase.CreateBook.CreateBookRequest;
import com.namlh.bookstore.main.book.domain.usecase.CreateCategory.CreateCategory;
import com.namlh.bookstore.main.book.domain.usecase.CreateCategory.CreateCategoryRequest;
import com.namlh.bookstore.main.book.domain.usecase.CreatePublisher.CreatePublisher;
import com.namlh.bookstore.main.book.domain.usecase.CreatePublisher.CreatePublisherRequest;
import com.namlh.bookstore.main.book.domain.usecase.FetchListBook.FetchListBook;
import com.namlh.bookstore.main.book.domain.usecase.FetchListBook.FetchListBookRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by app on 7/18/18.
 */
@RestController
@RequestMapping(Params.BOOK_PATH)
public class BookController {

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

    @RequestMapping(method = RequestMethod.POST)
    public Observable createBook(@RequestBody CreateBookRequest request) {
        return createBook.execute(request);
    }

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET)
    public Observable fetchListBook() {
        return fetchListBook.execute(new FetchListBookRequest());
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
