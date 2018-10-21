package com.spotted.spotted.integracao;

import com.spotted.models.Spotted;
import com.spotted.services.SpottedService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpottedServiceTest {

    @Autowired
    SpottedService spottedService;

    @Test
    public void test() {
        byte[] a = new byte[]{};
        spottedService.save(new Spotted("Minha casa", "CC", "Gata", a , true));
        System.out.println("!!!!!@@@@@@@@@@@@@@@((((((+++=======" + spottedService.getAll().toString());
    }

    @Test
    public void test2() {
        spottedService.save(new Spotted("Minha casa", "CC", "Gata", new byte[]{} , true));
    }
}
