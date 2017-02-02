package xyz.codingmentor.jpa.technical.application;

import javax.inject.Inject;
import xyz.codingmentor.jpa.technical.api.ProductEnum;
import xyz.codingmentor.jpa.technical.exception.RepositoryException;
import xyz.codingmentor.jpa.technical.entity.Product;
import xyz.codingmentor.jpa.technical.entity.Technican;
import xyz.codingmentor.jpa.technical.service.QueryService;

/**
 *
 * @author blazefury
 */
public class Application {

    @Inject
    private QueryService productService;

    public Application() {
        //empty on purpose
    }

    public void execute() throws RepositoryException {
        Product iphone = new Product();
        Product macpro = new Product();
        Product macbook = new Product();
        iphone.setProductName(ProductEnum.IPHONE);
        macpro.setProductName(ProductEnum.MACPRO);
        macbook.setProductName(ProductEnum.MACBOOK);

        Technican jeno=new Technican();
        Technican eszter=new Technican();
        Technican izabella=new Technican();
        jeno.setName("Jenő");
        eszter.setName("Eszter");
        izabella.setName("Izabella");

        productService.getProductsStartsWithSomething("m");
        productService.getTechByID(1);
        productService.getCheapestPart();
        productService.hireTechnican("Sándor");
        productService.fireTechnicianById(1);
    }

}
