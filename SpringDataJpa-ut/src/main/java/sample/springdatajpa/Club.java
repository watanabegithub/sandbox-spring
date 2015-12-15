package sample.springdatajpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/** Entityクラス */
@Entity
@Table(name="club")
public  class  Club {
    @Id
    public  Integer  clubCode;

    public  String  clubName;
}
