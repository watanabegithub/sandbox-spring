package sample.springbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.springbootweb.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,  String> {
    public UserInfo findByEmail(String email);
}
