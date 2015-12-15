package sample.springbootweb.app.product;

import org.hibernate.validator.constraints.Length;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.WebApplicationContext;
import sample.springbootweb.App;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/** ProductFormのUT */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class ProductFormTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductFormTest.class);

    /** バリデータ */
    private static Validator validator;

    /** 事前処理 */
    @Before
    public void 事前処理() throws Exception {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /** 事後処理 */
    @After
    public void 事後処理() throws Exception {
    }

    /** productNameの妥当性テスト */
    @Test
    public void productNameの妥当性テスト() throws Exception {
        ProductForm productForm = new ProductForm();
        productForm.setProductCode(1);
        productForm.setProductName("ポテトチップスうすしお");
        productForm.setPrice(100);

        // バリデート
        Set<ConstraintViolation<ProductForm>> violations = validator.validate(productForm);
        assertEquals(violations.size(), 1);
        for (ConstraintViolation<ProductForm> v: violations) {
            assertTrue(v.getConstraintDescriptor().getAnnotation() instanceof Length);
        }
    }
}
