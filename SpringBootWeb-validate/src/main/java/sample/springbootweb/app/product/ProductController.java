package sample.springbootweb.app.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.CharacterEncodingFilter;
import sample.springbootweb.service.product.DuplicateProductException;
import sample.springbootweb.service.product.ProductService;

import javax.servlet.Filter;
import javax.validation.Valid;

/** 商品関連のページを制御するController */
@Controller
@RequestMapping("product")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @ModelAttribute
    public ProductForm setupForm() {
        return new ProductForm();
    }

    /** 商品入力の開始 */
    @RequestMapping(value = "/input", method= RequestMethod.GET)
    public  String  input(Model model) {
        return "product/input";
    }

    /** 商品入力の確認 */
    @RequestMapping(value = "/confirm", method=RequestMethod.POST)
    public  String  confirm(Model model, @Valid ProductForm productForm, Errors errors) {
        if (errors.hasErrors()) {
            return "product/input";
        }
        try {
            productService.validate(productForm);
        } catch(DuplicateProductException e) {
            errors.rejectValue("productCode", "duplicate", new String[]{"商品コード"}, "default message.");
            return "product/input";
        }
        return "product/confirm";
    }

    /** 商品入力に戻る */
    @RequestMapping(value = "/input", method=RequestMethod.POST)
    public  String  back(Model model) {
        return "product/input";
    }

    /** 商品入力の登録 */
    @RequestMapping(value = "/regist", method=RequestMethod.POST)
    public  String  regist(Model model) {
        return "product/finish";
    }

    /** 商品一覧を表示する */
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public  String  list(Model model) {
        return "product/list";
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");

        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}
