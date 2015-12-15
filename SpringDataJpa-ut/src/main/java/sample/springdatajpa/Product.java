package sample.springdatajpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/** Entityクラス */
@Entity
@Table(name="product")
public class Product {
    @Id
    public Integer productCode;

    public String productName;

    public Integer price;
}
