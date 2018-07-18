package com.namlh.bookstore.main.book.domain.usecase.CreatePublisher;

import com.namlh.bookstore.main.book.data.entity.PublisherEntity;
import com.namlh.bookstore.main.book.data.repository.PublisherRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by app on 7/18/18.
 */
@Service
public final class CreatePublisherImpl implements CreatePublisher {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Observable<CreatePublisherResponse> execute(CreatePublisherRequest request) {
        return Observable.create(e -> e.onNext(toResponse(request)));
    }

    private CreatePublisherResponse toResponse(CreatePublisherRequest request) {
        PublisherEntity entity = new PublisherEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        publisherRepository.save(entity);
        return new CreatePublisherResponse(entity.getId());
    }
}
