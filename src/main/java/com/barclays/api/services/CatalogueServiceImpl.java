package com.barclays.api.services;

import com.barclays.api.domain.Catalogue;
import com.barclays.api.repositories.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author matthewbateup
 */

@Service
public class CatalogueServiceImpl implements CatalogueService {
    private CatalogueRepository catalogueRepository;

    @Autowired
    public void setCatalogueRepository(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Override
    public Iterable<Catalogue> listAllProducts() {
        return catalogueRepository.findAll();
    }

    @Override
    public Catalogue getProductById(Integer id) {
        return catalogueRepository.findOne(id);
    }

    @Override
    public Catalogue saveProduct(Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
    }

    @Override
    public void deleteProduct(Integer id) {
        catalogueRepository.delete(id);
    }

    @Override
    public Page<Catalogue> findAll(Pageable pageable) {
        return catalogueRepository.findAll(pageable);
    }
}
