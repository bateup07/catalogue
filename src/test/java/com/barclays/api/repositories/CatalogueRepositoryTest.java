package com.barclays.api.repositories;

import com.barclays.api.configuration.RepositoryConfiguration;
import com.barclays.api.domain.Catalogue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author matthewbateup
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class CatalogueRepositoryTest {

    private CatalogueRepository catalogueRepository;

    @Autowired
    public void setCatalogueRepository(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Test
    public void testSaveProduct(){
        //setup catalogue
        Catalogue catalogue = new Catalogue();
        catalogue.setDescription("New ATM available in Market Street, Manchester");
        catalogue.setProductId("XXX029");

        //save catalogue, verify has ID value after save
        assertNull(catalogue.getId()); //null before save
        catalogueRepository.save(catalogue);
        assertNotNull(catalogue.getId()); //not null after save

        //fetch from DB
        Catalogue fetchedCatalogue = catalogueRepository.findOne(catalogue.getId());

        //should not be null
        assertNotNull(fetchedCatalogue);

        //should equal
        assertEquals(catalogue.getId(), fetchedCatalogue.getId());
        assertEquals(catalogue.getDescription(), fetchedCatalogue.getDescription());

        //update description and save
        fetchedCatalogue.setDescription("Barclays has partnered with Curve which enables consumers to spend currencies worldwide");
        fetchedCatalogue.setHeader("FinTech");
        catalogueRepository.save(fetchedCatalogue);

        //get from DB, should be updated
        Catalogue fetchedUpdatedCatalogue = catalogueRepository.findOne(fetchedCatalogue.getId());
        assertEquals(fetchedCatalogue.getDescription(), fetchedUpdatedCatalogue.getDescription());

        //verify count of products in DB
        long productCount = catalogueRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Catalogue> products = catalogueRepository.findAll();

        int count = 0;

        for(Catalogue p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}
