package sample.springdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class AppTest {
    @Autowired
    private ProductRepository productRepository;

/*
    @Test
    public void testProductRepository() {
//        assertTrue( true );

        Product product = new Product();
        product.productCode = 1;
        product.productName = "ガム";
        product.price = 100;
        productRepository.save(product);

        System.out.println("hello");
    }
*/


    @Autowired
    private SampleService sampleService;

/*
    @Test
    public void transactionTest1() {
        sampleService.savePotechi();
        Integer price = sampleService.getPotechiPrice();
        System.out.println("PotechiPrice:" + price);
    }
    @Test
    public void transactionTest2() {
        try {
            sampleService.saveFailPotechi();
        } catch(RuntimeException e){
            System.out.println("RuntimeException:" + e.getMessage());
        }
        Integer price = sampleService.getPotechiPrice();
        System.out.println("PotechiPrice:" + price);
    }
*/

    @Test
    public void joinTest() {
//        Student student = sampleService.getStudent(1);
//        System.out.println("student code:" + student.studentCode+" clubName:"+student.club.clubName);
        Purchase purchase = sampleService.getPurchase(1);
    }
}
