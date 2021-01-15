package com.example.demo.repository;

import com.example.demo.model.Prroduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;


public interface ProductRepository extends JpaRepository<Prroduct, Long> {

    Page<Prroduct> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Prroduct> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
