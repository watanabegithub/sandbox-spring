package sample.springdatajpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class SampleService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public PurchaseRepository purchaseRepository;

    @Transactional(readOnly=false)
    public void savePotechi() {
        Product product = new Product();
        product.productCode = 11;
        product.productName = "ポテチ";
        product.price = 200;
        productRepository.save(product);
    }
    public void saveFailPotechi() {
        Product product = new Product();
        product.productCode = 11;
        product.productName = "ポテチ";
        product.price = 300;
        productRepository.save(product);
        throw new RuntimeException();
    }
    public Integer getPotechiPrice() {
        Product product = productRepository.findOne(11);
        return product.price;
    }

    public Student getStudent(Integer id) {
        return studentRepository.findOne(id);
    }

    public Purchase getPurchase(Integer id) {
        return purchaseRepository.findOne(id);
    }

    public String dataAccess() {
/*
        Product product = new Product();
        product.productCode = 1;
        product.productName = "ガム";
        product.price = 100;
        productRepository.save(product);
        product.productCode = 2;
        product.productName = "アメ";
        product.price = 150;
        productRepository.save(product);
        product.productCode = 3;
        product.productName = "チョコ";
        product.price = 120;
        productRepository.save(product);
*/

//        Product product2 = productRepository.findOne(1);
//        Product product2 = productRepository.findByProductName("ガム");
//        Product product2 = productRepository.findByProductNameAndPrice("ガム", 1000);
//        Product product2 = productRepository.findByProductNameOrPrice("ガム", 1000);
//        Product product2 = productRepository.findByPriceGreaterThanEqual(150);
//        Product product2 = productRepository.findByAme();
//        Product product2 = productRepository.purchasedByYamada();
//        Product product2 = productRepository.findByXXX("アメ");
        Product product2 = productRepository.findByXXXX("アメ");
        System.out.println(product2==null? "null": product2.productName);

//        List<Product> list = productRepository.findByProductNameOrderByPriceAsc("ガム");
//        List<Product> list = productRepository.findByOrderByPriceDesc();
//        list.stream().forEach(product2 -> System.out.println(product2.productName+" "+product2.price));
//        productRepository.findByOrderByPriceDescStream()
//            .forEach(product2 -> System.out.println(product2.productName+" "+product2.price));
//        List<Product> list = productRepository.purchasedByYamada();
//        list.stream().forEach(product2 -> System.out.println(product2.productName+" "+product2.price));


        return "";
    }

}
