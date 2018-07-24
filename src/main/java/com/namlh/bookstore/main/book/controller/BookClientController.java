package com.namlh.bookstore.main.book.controller;

import com.namlh.bookstore.main.book.domain.usecase.FetchListBook.FetchListBook;
import com.namlh.bookstore.main.book.domain.usecase.FetchListBook.FetchListBookRequest;
import com.namlh.bookstore.utils.Params;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.namlh.bookstore.utils.Params.DEFAULT_LIMIT;

/**
 * Created by app on 7/23/18.
 */
@RestController
@RequestMapping(Params.CLIENT_PATH + Params.BOOK_PATH)
public class BookClientController {

    @Autowired
    private FetchListBook fetchListBook;

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
}
