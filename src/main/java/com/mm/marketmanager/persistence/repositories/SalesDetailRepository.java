package com.mm.marketmanager.persistence.repositories;

import com.mm.marketmanager.persistence.entities.SalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing SalesDetails entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 *
 * @author caito
 *
 */
public interface SalesDetailRepository extends JpaRepository<SalesDetails, Long> {
}
