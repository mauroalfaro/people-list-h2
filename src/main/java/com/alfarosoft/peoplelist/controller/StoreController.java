package com.alfarosoft.peoplelist.controller;

import com.alfarosoft.peoplelist.model.Store;
import com.alfarosoft.peoplelist.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveStore (@RequestBody Store store){
        storeService.saveStore(store);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Store> lookupStore (@PathVariable String id){
        if(storeService.lookupStore(id).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(storeService.lookupStore(id).get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Store>> searchStore (){
        return ResponseEntity.status(HttpStatus.OK).body(storeService.searchStores());
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStore (@PathVariable String id, @RequestBody Store store){
        storeService.updateStoreById(id, store);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStore (@PathVariable String id){
        storeService.deleteStoreById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleException(final EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
