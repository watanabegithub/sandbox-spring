package sample.springbootweb.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.springbootweb.App;
import sample.springbootweb.model.Product;

import static org.junit.Assert.assertEquals;

/** ProductRepositoryのUT */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public  class  ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    /** 事前処理 */
    @Before
    public void 事前処理() throws Exception {
        Product product1  =  new  Product();
        product1.productCode  =  1;
        product1.productName  =  "ガム";
        product1.price  =  100;
        productRepository.save(product1);

        Product  product2  =  new  Product();
        product2.productCode  =  2;
        product2.productName  =  "アメ";
        product2.price  =  120;
        productRepository.save(product2);
    }

    /** 事後処理 */
    @After
    public void 事後処理() throws Exception {
    }

    /** findOneメソッドのテスト */
    @Test
    public  void  findOneメソッドのテスト() {
        Product  product  =  productRepository.findOne(1);
        assertEquals(product.productName, "ガム");
    }
}
