package com.productinfo.product.controller;

import com.productinfo.product.model.product;
import com.productinfo.product.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@CrossOrigin("http://127.0.0.1:5500/")
@RestController
@RequestMapping("/products")
public class productcontroller {

    @Autowired
    private productservice productservice;
    //get all data
    @GetMapping
    public Flux<product> getallproducts(){
        return productservice.getall();
    }

    //get data by id
    @GetMapping("/{id}")
    public Mono<product> getbyid(@PathVariable String id){
        return productservice.getbyid(id);
    }

    //post data
    @PostMapping
    public Mono<product> createproduct(@RequestBody product product){
        return productservice.save(product);
    }

    //update the data
    @PutMapping("/{id}")
    public Mono<product> updatedproduct(@PathVariable String id, @RequestBody product updatedproduct){
        return productservice.updateproduct(id,updatedproduct);
    }

    //delete the data
    @DeleteMapping("/{id}")
    public Mono<Void> deleteproduct(@PathVariable String id){
        return productservice.deleteproduct(id);
    }
}
