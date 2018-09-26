package com.barclays.api.bootstrap;

import com.barclays.api.domain.Catalogue;
import com.barclays.api.repositories.CatalogueRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author matthewbateup
 */

@Component
public class CatalogueLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CatalogueRepository catalogueRepository;

    private Logger log = Logger.getLogger(CatalogueLoader.class);

    @Autowired
    public void setCatalogueRepository(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Catalogue c1 = new Catalogue();
        c1.setHeader("Branch Details");
        c1.setDescription("Test Test Test Test");
        c1.setImageUrl("http://www.fake.com");
        c1.setProductId("XXX12");
        catalogueRepository.save(c1);

        log.info("Saved Product - id: " + c1.getId());

        Catalogue c2 = new Catalogue();
        c2.setHeader("Product Details");
        c2.setDescription("Test Test Test Test");
        c2.setImageUrl("http://www.fake.com");
        c2.setProductId("XXX13");
        catalogueRepository.save(c2);

        log.info("Saved Product - id:" + c2.getId());

        Catalogue c3 = new Catalogue();
        c3.setHeader("ATM Locator");
        c3.setDescription("Test Test Test Test");
        c3.setImageUrl("http://www.fake.com");
        c3.setProductId("XXX14");
        catalogueRepository.save(c3);

        log.info("Saved Product - id:" + c3.getId());
    }
}