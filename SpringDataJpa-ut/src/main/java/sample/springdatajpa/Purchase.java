package sample.springdatajpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.sql.Date;
import java.util.List;

/** Entityクラス */
@Entity
@Table(name="purchase")
public class Purchase {
    @Id
    public Integer purchaseCode;

    public Date purchaseDate;

    public String purchaser;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "purchase_code")
    public List<PurchaseDetail> purchaseDetailList;
}
