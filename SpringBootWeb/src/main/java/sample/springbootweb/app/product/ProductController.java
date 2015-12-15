package sample.springbootweb.app.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import sample.springbootweb.service.product.ProductService;
import sample.springbootweb.model.Product;

/** 商品関連のページを制御するController */
@Controller
@RequestMapping("product")
public  class  ProductController {

    @Autowired
    private  ProductService  productService;

    /** 商品一覧を表示する */
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public  String  list(Model model) {
        List<Product>  list  =  productService.getProductList();
        model.addAttribute("productList", list);
        return "product/list";
    }
}

