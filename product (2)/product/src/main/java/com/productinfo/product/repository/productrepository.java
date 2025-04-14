package com.productinfo.product.repository;

import com.productinfo.product.model.product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface productrepository extends ReactiveMongoRepository<product,String> {

}
