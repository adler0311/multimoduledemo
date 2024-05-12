package com.blog;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfiguration.class}) // 필요한 구성 클래스를 지정
@DataJpaTest
public class ConfirmRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ConfirmRepository confirmRepository;

    @Test
    public void whenFindById_thenReturnConfirm() {
        // given
        Confirm confirm = new Confirm(1L, "Test Description");
        entityManager.persist(confirm);
        entityManager.flush();

        // when
        Confirm found = confirmRepository.findById(confirm.getId()).orElse(null);

        // then
        assertThat(found.getDescription()).isEqualTo(confirm.getDescription());
    }

    @Test
    public void whenSave_thenReturnSavedConfirm() {
        // given
        Confirm confirm = new Confirm(2L, "Save New Confirm");

        // when
        Confirm savedConfirm = confirmRepository.save(confirm);

        // then
        Confirm found = entityManager.find(Confirm.class, savedConfirm.getId());
        assertThat(found).isEqualTo(savedConfirm);
    }
}