package com.productinfo.product.service;

import com.productinfo.product.model.product;
import com.productinfo.product.repository.productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class productservice {

    @Autowired
    private productrepository productrepository;

    //get all the data
    public Flux<product> getall() {
        return productrepository.findAll();
    }

    //get data by id
    public Mono<product> getbyid(String id) {
        return productrepository.findById(id);
    }

    //save the new data
    public Mono<product> save(product product) {
        return productrepository.save(product);
    }

    //update the data
    public Mono<product> updateproduct(String id, product updatedproduct) {
        return productrepository.findById(id)
                .flatMap(exist -> {
                    exist.setName(updatedproduct.getName());
                    exist.setPrice(updatedproduct.getPrice());
                    exist.setCategory(updatedproduct.getCategory());
                    return productrepository.save(exist);
                });
    }

    //delete the data
    public Mono<Void> deleteproduct(String id) {
        return productrepository.deleteById(id);
    }
}