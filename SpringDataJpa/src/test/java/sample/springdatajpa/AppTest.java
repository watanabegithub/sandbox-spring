package sample.springdatajpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import sample.springdatajpa.model.Club;
import sample.springdatajpa.repository.ClubRepository;
import sample.springdatajpa.repository.StudentRepository;

/**
 * Created by k_watanabe on 2015/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
public class AppTest {
    @Autowired
    private ClubRepository clubRepository;

//    @Autowired
//    private StudentRepository studentRepository;

    @Before
    public void setup() {

    }

    @Test
    public void テスト() throws Exception {
        Club club = new Club();
        club.setClubCode(1);
        club.setClubName("aaa");
        clubRepository.save(club);
    }
}
