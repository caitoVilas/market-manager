package com.mm.marketmanager.persistence.repositories;

import com.mm.marketmanager.persistence.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Sale entities in the market manager application.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 *
 * @author caito
 *
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
