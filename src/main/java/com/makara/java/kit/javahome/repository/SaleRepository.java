package com.makara.java.kit.javahome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makara.java.kit.javahome.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

}
