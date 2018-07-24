package com.namlh.bookstore.main.book.controller;

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
 * Created by app on 7/23/18.
 */
@RestController
@RequestMapping(Params.CLIENT_PATH + Params.BOOK_PATH)
public class BookClientController {

    @Autowired
    private FetchListBook fetchListBook;

    @Autowired
    private ReadBookById readBookById;

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

    //Book detail
    @RequestMapping(
            value = "/{bookId}", method = RequestMethod.GET)
    public Observable readBookInfo(@PathVariable("bookId") Integer bookId) {
        return readBookById.execute(new ReadBookByIdRequest(bookId));
    }
}
