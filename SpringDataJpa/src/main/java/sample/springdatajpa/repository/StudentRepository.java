package sample.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by k_watanabe on 2015/11/26.
 */
public interface StudentRepository
        extends JpaRepository<StudentRepository,  Integer> {
}
