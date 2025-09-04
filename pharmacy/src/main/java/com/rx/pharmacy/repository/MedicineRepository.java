package com.rx.pharmacy.repository;

import com.rx.pharmacy.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    // Spring Data JPA gives you save(), findAll(), findById(), delete() automatically
}
