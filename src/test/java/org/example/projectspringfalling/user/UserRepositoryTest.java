package org.example.projectspringfalling.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByEmail_test() {
        // given
        Integer userId = 6;

        // when
        User user = userRepository.findByEmail("tom@nate.com");

        // eye
        System.out.println("user = " + user);

        // then
        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getEmail()).isEqualTo("tom@nate.com");
    }
}
