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
import javax.validation.metadata.ConstraintDescriptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/** ProductControllerのUT */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
public class ProductControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductControllerTest.class);

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    /** 事前処理 */
    @Before
    public void 事前処理() throws Exception {
        mockMvc = webAppContextSetup(wac).build();
    }

    /** 事後処理 */
    @After
    public void 事後処理() throws Exception {
    }

    /** 入力画面の初期表示のテスト */
    @Test
    public void 入力画面の初期表示のテスト() throws Exception {
        mockMvc.perform(get("/product/input"))
                .andExpect(status().isOk())
                .andExpect(model().hasNoErrors());
    }

    /** 入力画面から確認画面に遷移するテスト */
    @Test
    public void 入力画面から確認画面に遷移するテスト() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(post("/product/confirm")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("productCode", "1")
                                .param("productName", "ポテトチップスうすしお")
                                .param("price", "100")
                );

        // レスポンスの検証
        resultActions.andExpect(status().isOk())
                .andExpect(model().hasNoErrors());

        // モデルの内容の検証
        ModelMap modelMap = resultActions.andReturn().getModelAndView().getModelMap();
        ProductForm productForm = (ProductForm)modelMap.get("productForm");
        assertEquals(productForm.getProductCode(), new Integer(1));
        assertEquals(productForm.getProductName(), "ガム");
        assertEquals(productForm.getPrice(), new Integer(100));

    }

/*
    @Test
    public void 入力画面から確認画面に遷移するテスト_validate_productName() throws Exception {
        ResultActions resultActions =
                mockMvc.perform(post("/product/confirm")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("productCode", "1")
                                .param("productName", "ポテトチップスうすしお")
                                .param("price", "100")
                );

        // レスポンスの検証
        resultActions.andExpect(status().isOk())
                .andExpect(view().name("product/input"))                                        // 確認ではなく、入力画面に
                .andExpect(model().hasErrors())                                                   // エラーがあること
                .andExpect(model().errorCount(1))                                                 // エラー件数は1件
                .andExpect(model().attributeHasFieldErrors("productForm", "productName"));    // productNameがエラー

        // エラーメッセージは、「org.springframework.validation.BindingResult.モデル名」に格納される。
        Object object = resultActions.andReturn().getModelAndView().getModel().get(
                "org.springframework.validation.BindingResult.productForm");
        assertThat(object, is(not(nullValue())));
        assertThat(object, is(instanceOf(BindingResult.class)));
        BindingResult bindingResult = (BindingResult) object;

        // productNameのエラーを取り出しテスト
        List<FieldError> list = bindingResult.getFieldErrors("productName");
        assertThat(list, is(not(nullValue())));
        assertThat(list.size(), is(1));

        // Lengthエラーか？
        FieldError fieldError = list.get(0);
        assertThat(fieldError.getCode(), is("Length"));
    }
*/
}
