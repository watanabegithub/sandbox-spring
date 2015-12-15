package sample.springdatajpa;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

/** Repositoryクラス */
public interface StudentRepository
    extends JpaRepository <Student, Integer> {
}
