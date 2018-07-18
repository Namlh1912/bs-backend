package com.namlh.bookstore.main.book.domain.usecase.CreateCategory;

import com.namlh.bookstore.main.book.data.entity.CategoryEntity;
import com.namlh.bookstore.main.book.data.repository.CategoryRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/18/18.
 */
@Service
public final class CreateCategoryImpl implements CreateCategory {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Observable<CreateCategoryResponse> execute(CreateCategoryRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private CreateCategoryResponse toResponse(CreateCategoryRequest request) {
        CategoryEntity entity = new CategoryEntity();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        categoryRepository.save(entity);
        return new CreateCategoryResponse(entity.getId());
    }
}
