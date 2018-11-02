package com.spotted.spotted.unidade;

import com.spotted.models.Comment;
import com.spotted.models.Spotted;
import com.spotted.services.SpottedService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * Testes de unidade para {@link SpottedService}
 *
 * @author cassioegc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpottedServiceTest {

    @Autowired
    private SpottedService spottedService;

    private Spotted spotted;

    @Before
    public void setUp() {
        this.spotted = new Spotted("Teste 1", "teste", "teste", new byte[]{} , true);
    }

    /**
     * Testa se um spotted é salvo com sucesso.
     */
    @Test
    public void testSave() {
        Spotted spottedSaved = spottedService.save(this.spotted);
        Assert.assertTrue("O spotted deveria ter sido salvo.", spottedService.getAll().contains(this.spotted));
        Assert.assertEquals("Os spotteds deveriam ser iguais", spottedSaved, this.spotted);
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
     * Testa se um spotted null não é salvo.
     */
    @Test
    public void testSaveNull() {
        Spotted spotted = null;
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

    /**
     * Testa se um comentário é adicionado ao spotted corretamente.
     * @throws Exception 
     */
    @Test
    public void testAddComment() throws Exception {
        Spotted spottedSaved = spottedService.save(this.spotted);

        Assert.assertTrue("O spotted não deveria ter comentários.", spottedSaved.getComments().isEmpty());

        Comment comment = new Comment("", "Comentário de teste.");
        spottedService.addComment(spottedSaved.getId(), comment);
        Set<Comment> comments = spottedService.getComments(this.spotted.getId());

        Assert.assertFalse("O spotted deveria ter comentários.", comments.isEmpty());
        Assert.assertTrue("O comentário deveria estar no conjunto de comentários do spotted",
                    comments.contains(comment));
    }

    /**
     * Testa se um comentário com texto vazio não é salvo.
     */
    @Test
    public void testAddCommentEmptyText() {
        Spotted spottedSaved = spottedService.save(this.spotted);

        Assert.assertTrue("O spotted não deveria ter comentários.", spottedSaved.getComments().isEmpty());

        Comment comment = new Comment("", "");

        try {
            spottedService.addComment(spottedSaved.getId(), comment);
            Assert.fail("O comentário não deveria ter sido salvo.");
        } catch (Exception e) {
            Set<Comment> comments = spottedService.getComments(this.spotted.getId());
            Assert.assertFalse("O comentáario não deveria ter sido salvo.", comments.contains(comment));
        }
    }

    /**
     * Testa se um comentário com texto null não é salvo.
     */
    @Test
    public void testAddCommentNullText() {
        Spotted spottedSaved = spottedService.save(this.spotted);

        Assert.assertTrue("O spotted não deveria ter comentários.", spottedSaved.getComments().isEmpty());

        Comment comment = new Comment("", null);

        try {
            spottedService.addComment(spottedSaved.getId(), comment);
            Assert.fail("O comentário não deveria ter sido salvo.");
        } catch (Exception e) {
            Set<Comment> comments = spottedService.getComments(this.spotted.getId());
            Assert.assertFalse("O comentáario não deveria ter sido salvo.", comments.contains(comment));
        }
    }

    /**
     * Testa se um comentário com texto null não é salvo.
     */
    @Test
    public void testAddCommentNull() {
        Spotted spottedSaved = spottedService.save(this.spotted);

        Assert.assertTrue("O spotted não deveria ter comentários.", spottedSaved.getComments().isEmpty());

        Comment comment = null;

        try {
            spottedService.addComment(spottedSaved.getId(), comment);
            Assert.fail("O comentário não deveria ter sido salvo.");
        } catch (Exception e) {
            Set<Comment> comments = spottedService.getComments(this.spotted.getId());
            Assert.assertFalse("O comentáario não deveria ter sido salvo.", comments.contains(comment));
        }
    }

    @Test
    public void testAddCommentSpottedNonexistent() throws Exception {
        Comment comment = new Comment("", "Comentário de teste.");
        Long idInvalid = Long.valueOf(-1);
        Assert.assertNull("O retorno deveria ser um null.", spottedService.addComment(idInvalid, comment));
    }

    /**
     * Testa se os spotteds adicinados são retornados.
     */
    @Test
    public void testGetAll() {
        Spotted spotted1 = new Spotted("Teste 1", "T1", "Teste 1", new byte[]{}, true);
        Spotted spotted2 = new Spotted("Teste 2", "T2", "Teste 2", new byte[]{}, true);
        spottedService.save(spotted1);
        spottedService.save(spotted2);
        Assert.assertTrue("Os spotted 1 deveria estar na lista", spottedService.getAll().contains(spotted1));
        Assert.assertTrue("Os spotted 2 deveria estar na lista", spottedService.getAll().contains(spotted2));
    }
}
