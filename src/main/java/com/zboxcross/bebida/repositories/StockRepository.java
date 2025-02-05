package com.zboxcross.bebida.repositories;

import com.zboxcross.bebida.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
