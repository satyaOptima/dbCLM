package com.test.dbCLM.repository;

import com.test.dbCLM.entity.NaceData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;


@DataJpaTest
public class NaceDataRepositoryIntTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private NaceDataRepository naceDataRepository;

    @Test
    public void whenFindByOrder_thenReturnNaceData(){
        NaceData naceData = new NaceData();
        naceData.setOrder("1234");
        testEntityManager.persist(naceData);
        testEntityManager.flush();

        NaceData found = naceDataRepository.findByOrder(naceData.getOrder());
        System.out.println("Data "+found);
        Assertions.assertEquals(found.getOrder(),naceData.getOrder());
    }
}
