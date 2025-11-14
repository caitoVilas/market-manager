package com.mm.marketmanager.persistence.repositories;

import com.mm.marketmanager.persistence.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing Branch entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 *
 * @author caito
 *
 */
public interface BranchRepository extends JpaRepository<Branch, Long> {
    Optional<Branch> findByEmail(String email);
    Optional<Branch> findByCuit(String cuit);
    boolean existsByCuit(String cuit);
    boolean existsByEmail(String email);
}
