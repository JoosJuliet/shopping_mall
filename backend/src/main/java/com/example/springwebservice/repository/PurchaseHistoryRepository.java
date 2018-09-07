package com.example.springwebservice.repository;

import com.example.springwebservice.model.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Integer>{

}
