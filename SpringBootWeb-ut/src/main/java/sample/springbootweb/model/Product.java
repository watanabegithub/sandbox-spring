package sample.springbootweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** productテーブルのEntity */
@Entity
@Table(name="product")
public  class  Product {
    /** 商品コード */
    @Id
    public  Integer  productCode;

    /** 商品名 */
    public  String  productName;

    /** 価格 */
    public  Integer  price;
}
