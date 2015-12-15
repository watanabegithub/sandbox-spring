package sample.springbootweb.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.springbootweb.model.Product;
import sample.springbootweb.repository.ProductRepository;

import java.util.List;

/** 商品関連のビジネスロジックを実行するService */
@Service
public  class  ProductService {
    @Autowired
    ProductRepository productRepository;

    /** 商品一覧を返す */
    public List<Product> getProductList() {
        List<Product>  list  =  productRepository.findAll();
        return  list;
    }
}
