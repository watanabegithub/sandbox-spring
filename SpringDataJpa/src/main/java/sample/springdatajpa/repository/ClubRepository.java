package sample.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.springdatajpa.model.Club;

/**
 * Created by k_watanabe on 2015/11/26.
 */
public interface ClubRepository
        extends JpaRepository<Club,  Integer> {
}
