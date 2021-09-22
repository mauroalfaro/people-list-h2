package com.alfarosoft.peoplelist.repository;

import com.alfarosoft.peoplelist.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, String> {
}
