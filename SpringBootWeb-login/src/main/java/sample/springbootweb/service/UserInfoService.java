package sample.springbootweb.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import sample.springbootweb.model.UserInfo;
import sample.springbootweb.repository.UserInfoRepository;

@Component
public class UserInfoService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {
        if (s==null || "".equals(s)) {
            throw new UsernameNotFoundException("Username is empty");
        }

        UserInfo userInfo = userInfoRepository.findByEmail(s);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User not found for name: " + s);
        }

        // 実験
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String salt = BCrypt.gensalt();
        logger.debug("■■■encode "+userInfo.getUsername() + "->" + encoder.encode(userInfo.getUsername()));
        logger.debug("■■■encode "+userInfo.getPassword() + "->" + encoder.encode(userInfo.getPassword()));
        logger.debug("■■■password salt " + salt);
        logger.debug("■■■password " + "test2" + "->" + BCrypt.hashpw("test2", salt));
        System.out.println("■■■encode " + userInfo.getUsername() + "->" + encoder.encode(userInfo.getUsername()));
        System.out.println("■■■encode " + userInfo.getPassword() + "->" + encoder.encode(userInfo.getPassword()));
        System.out.println("■■■password salt " + salt);
        System.out.println("■■■password " + "test2" + "->" + BCrypt.hashpw("test2", salt));
        System.out.println("■■■password " + "testpassword" + "->" + BCrypt.hashpw("testpassword", BCrypt.gensalt()));
        System.out.println("■■■password " + "testpassword" + "->" + BCrypt.hashpw("testpassword", BCrypt.gensalt()));
        System.out.println("■■■password " + "admin" + "->" + BCrypt.hashpw("admin", BCrypt.gensalt()));
        return userInfo;
    }
}
