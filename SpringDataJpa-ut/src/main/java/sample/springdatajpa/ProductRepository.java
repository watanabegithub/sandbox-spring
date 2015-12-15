package sample.springdatajpa;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repositoryクラス */
public interface ProductRepository
    extends JpaRepository <Product, Integer> {

    public Product findByProductName(String productName);
    public Product findByProductNameAndPrice(String productName, Integer price);
    public Product findByProductNameOrPrice(String productName, Integer price);
    public List<Product> findByProductNameOrderByPriceAsc(String productName);
    public Product findByPriceLessThan(Integer price);
    public Product findByPriceGreaterThan(Integer price);
    public Product findByPriceGreaterThanEqual(Integer price);

    @Query("select p from Product p where p.productName='アメ'")
    public Product findByAme();

    @Query("select p from Product p where p.productName=?1")
    public Product findByXXX(String name);

    @Query("select p from Product p where p.productName=:name")
    public Product findByXXXX(@Param("name") String name);

//           "    join purchase_detail pd on (pr.product_code=pd.product_code) ")
//           "    inner join purchase pu on (pd.purchaseCode=pu.purchaseCode) "+
//           "where pu.purchaser='山田'")
//    @Query("select pr from Product pr join PurchaseDetail pd on pr.productCode = pd.productCode")
//    public List<Product> purchasedByYamada();

}
