package com.barclays.api.repositories;

import com.barclays.api.domain.Catalogue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author matthewbateup
 */

public interface CatalogueRepository extends CrudRepository<Catalogue, Integer> {
    Page<Catalogue> findAll(Pageable pageable);
}