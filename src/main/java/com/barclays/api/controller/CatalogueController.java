package com.barclays.api.controller;

import com.barclays.api.domain.Catalogue;
import com.barclays.api.services.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author matthewbateup
 */

@Controller
public class CatalogueController {

    private CatalogueService catalogueService;

    @Autowired
    public void setCatalogueService(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String displayProducts(Model model, Pageable pageable){
        Page<Catalogue> productPage = catalogueService.findAll(pageable);
        PageWrapper<Catalogue> page = new PageWrapper<Catalogue>(productPage, "/products");
        model.addAttribute("products", page.getContent());
        model.addAttribute("page", page);
        return "products";
    }

    @RequestMapping("product/{id}")
    public String showProductById(@PathVariable Integer id, Model model){
        model.addAttribute("product", catalogueService.getProductById(id));
        return "productshow";
    }
}