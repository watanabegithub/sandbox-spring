package sample.springbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.springbootweb.model.Product;

/** productテーブルのRepository */
public  interface  ProductRepository
    extends  JpaRepository  <Product,  Integer> {
}
