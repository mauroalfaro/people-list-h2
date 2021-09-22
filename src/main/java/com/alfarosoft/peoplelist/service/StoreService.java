package com.alfarosoft.peoplelist.service;

import com.alfarosoft.peoplelist.model.Employee;
import com.alfarosoft.peoplelist.model.Store;
import com.alfarosoft.peoplelist.repository.EmployeeRepository;
import com.alfarosoft.peoplelist.repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StoreService {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void saveStore (Store store){
        storeRepository.save(store);
    }

    public void deleteStoreById (String storeId){
        storeRepository.deleteById(storeId);
    }

    public Optional<Store> lookupStore (String storeId){
        return storeRepository.findById(storeId);
    }

    public List<Store> searchStores() {
        return storeRepository.findAll();
    }

    public void updateStoreById (String storeId, Store store) {
        if (storeRepository.findById(storeId).isPresent()) {
            Store storeUpdated = Store.builder()
                    .id(storeId)
                    .storeName(store.getStoreName())
                    .address(store.getAddress())
                    .build();
            storeRepository.save(storeUpdated);
        }
    }
}
