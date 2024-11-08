package com.example.erpproduit.Repository;

import com.example.erpproduit.Entity.AttributGenerique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttributGeneriqueRepository extends JpaRepository<AttributGenerique, Long> {
    Optional<AttributGenerique> findAllById(Long id);
}

