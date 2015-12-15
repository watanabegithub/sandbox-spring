package sample.springbootweb.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.springbootweb.App;
import sample.springbootweb.model.Product;
import sample.springbootweb.service.product.ProductService;

import java.util.List;

/** ProductServiceのUT */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    /** 事前処理 */
    @Before
    public void 事前処理() throws Exception {
    }

    /** 事後処理 */
    @After
    public void 事後処理() throws Exception {
    }

    /** プロダクト一覧を取得できるかのテスト */
    @Test
    public void プロダクト一覧を取得できるかのテスト() {
        List<Product> list = productService.getProductList();

    }
}
