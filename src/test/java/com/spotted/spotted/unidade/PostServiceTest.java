package com.spotted.spotted.unidade;

import com.spotted.enums.PostTypes;
import com.spotted.models.Comment;
import com.spotted.models.Post;
import com.spotted.services.PostService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Testes de unidade para {@link PostService}
 *
 * @author cassioegc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    private Post post;

    @Before
    public void setUp() {
        this.post = new Post("email@test.com", "Texto de teste.", new byte[]{}, PostTypes.NEWS);
    }

    /**
     * Testa o salvamento de um post válido.
     */
    @Test
    public void testSave() {
        Post postSaved = this.postService.save(this.post);
        Assert.assertTrue("O post deveria ter sido salvo.", this.postService.getAll().contains(this.post));
        Assert.assertEquals("Os posts deveriam ser iguais.", this.post, postSaved);
    }

    /**
     * Testa se um post com email vazio não é salvo.
     */
    @Test
    public void testSaveEmailEmpty() {
        Post post = new Post("", "Texto de teste.", new byte[]{},  PostTypes.ENTERTAINMENT);
        try {
            this.postService.save(post);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O post não deveria ter sido salvo.", this.postService.getAll().contains(post));
        }
    }

    /**
     * Testa se um post com email null não é salvo.
     */
    @Test
    public void testSaveEmailNull() {
        Post post = new Post(null, "Texto de teste.", new byte[]{},  PostTypes.ENTERTAINMENT);
        try {
            this.postService.save(post);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O post não deveria ter sido salvo.", this.postService.getAll().contains(post));
        }
    }

    @Test
    public void testSavePostTypeNull() {
        Post post = new Post("email@test.com", "Texto de teste.", new byte[]{},  null);
        try {
            this.postService.save(post);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O post não deveria ter sido salvo.", this.postService.getAll().contains(post));
        }
    }

    /**
     * Testa se o spotted é retornado na procura por email.
     */
    @Test
    public void testSearchByEmail() {
        this.postService.save(this.post);
       Assert.assertTrue("O spotted deveria estar na lista.",
               this.postService.searchByEmail("email@test.com"). contains(this.post));
    }

    /**
     * Testa se o spotted é retornado na procura por email.
     */
    @Test
    public void testSearchByEmailEmpty() {
        this.postService.save(this.post);
        Assert.assertTrue("Deveria ter retornado uma lisat vazia.",
                this.postService.searchByEmail("").isEmpty());
    }

    /**
     * Testa se um post é apagado.
     */
    @Test
    public void testDeleteById() {
        Post postSaved = this.postService.save(this.post);
        Assert.assertTrue("O post deveria ter sido salvo.", this.postService.getAll().contains(postSaved));
        this.postService.deleteById(postSaved.getId());
        Assert.assertFalse("O post deveria ter sido apagado.", this.postService.getAll().contains(postSaved));
    }

    /**
     * Testa se uma exceção é lançada ao deletar um post com id inválido.
     */
    @Test
    public void testDeleteByIdInvalid() {
        Long id = Long.valueOf(-1);
        Post[] posts = (Post[]) this.postService.getAll().toArray();
        try {
          this.postService.deleteById(id);
          Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertArrayEquals("As listas deveriam ser iguais.",
                    posts, this.postService.getAll().toArray());
        }
    }

    @Test
    public void testAddComment() {
        this.postService.save(this.post);
        Comment comment = new Comment();
    }
}
