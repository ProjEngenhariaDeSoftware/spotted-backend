package com.spotted.spotted.unidade;

import com.spotted.models.Spotted;
import com.spotted.services.SpottedService;
import com.spotted.spotted.SpottedApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * Testes de unidade para {@link SpottedService}
 *
 * @author cassioegc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpottedServiceTest extends SpottedApplicationTests {

    @Autowired
    private SpottedService spottedService;

    /**
     * Testa se um spotted é salvo com sucesso.
     */
    @Test
    public void testSave() {
        Spotted spotted = new Spotted("Teste 1", "teste", "teste", new byte[]{} , true);
        Spotted spottedSaved = spottedService.save(spotted);
        Assert.assertTrue("O spotted deveria ter sido salvo.", spottedService.getAll().contains(spotted));
        Assert.assertEquals("Os spotteds deveriam ser iguais", spottedSaved, spotted);
    }

    /**
     * Testa se um spotted com texto vazio não é salvo.
     */
    @Test
    public void testSaveEmptyText() {
        Spotted spotted = new Spotted("Teste 1", "teste", "", new byte[]{} , true);
        try {
            spottedService.save(spotted);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O spotted não deveria ter sido salvo.", spottedService.getAll().contains(spotted));
        }
    }

    /**
     * Testa se um spotted com texto null não é salvo.
     */
    @Test
    public void testSaveNullText() {
        Spotted spotted = new Spotted("Teste 1", "teste", null, new byte[]{} , true);
        try {
            spottedService.save(spotted);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O spotted não deveria ter sido salvo.", spottedService.getAll().contains(spotted));
        }
    }
}
