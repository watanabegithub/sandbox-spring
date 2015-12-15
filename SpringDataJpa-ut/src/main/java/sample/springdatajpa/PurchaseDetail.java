package sample.springdatajpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/** Entityクラス */
@Entity
@Table(name="purchase_detail")
public class PurchaseDetail {
    @Id
    public Integer seq;
    public Integer purchaseCode;
    public Integer productCode;
    public Integer purchaseCount;
}
