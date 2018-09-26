package com.barclays.api.services;

import com.barclays.api.domain.Catalogue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author matthewbateup
 */

public interface CatalogueService {
    Iterable<Catalogue> listAllProducts();

    Catalogue getProductById(Integer id);

    //future option
    Catalogue saveProduct(Catalogue catalogue);

    //future option
    void deleteProduct(Integer id);

    Page<Catalogue> findAll(Pageable pageable);
}