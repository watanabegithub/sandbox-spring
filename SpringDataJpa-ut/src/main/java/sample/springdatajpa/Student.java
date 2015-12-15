package sample.springdatajpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/** Entityクラス */
@Entity
@Table(name="student")
public  class  Student {
    @Id
    public  Integer  studentCode;

    @ManyToOne
    public  Club  club;

    public  String  studentName;
}
