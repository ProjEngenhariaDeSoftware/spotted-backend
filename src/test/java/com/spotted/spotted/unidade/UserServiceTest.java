package com.spotted.spotted.unidade;

import com.spotted.models.User;
import com.spotted.services.UserService;
import com.spotted.spotted.SpottedApplicationTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import static java.util.Arrays.asList;


/**
 * Testes de unidade para {@link UserService}
 *
 * @author thiagomoura21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest extends SpottedApplicationTests {

    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void setUp() {
        this.user = new User("thiago.moura@ccc.ufcg.edu.br", "thiagomoura21");
    }

    /**
     * Testa se um user é salvo com sucesso.
     */
    @Test
    public void testSave() {
        User userSaved = userService.save(this.user);

        Assert.assertTrue("O user deveria ter sido salvo.", userService.getAll().contains(this.user));
        Assert.assertEquals("Os users deveriam ser iguais", userSaved, this.user);
    }

    /**
     * Testa se um user null não é salvo.
     */
    @Test
    public void testSaveNull() {
        User user = null;
        try {
            userService.save(user);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O user não deveria ter sido salvo.", userService.getAll().contains(user));
        }
    }

    /**
     * Testa se um user vazio não é salvo.
     */
    @Test
    public void testSaveEmpty() {
        User user = new User();
        try {
            userService.save(user);
            Assert.fail("Uma exceção deveria ter sido lançada.");
        } catch (Exception e) {
            Assert.assertFalse("O user não deveria ter sido salvo.", userService.getAll().contains(user));
        }
    }

    /**
     * Testa se um user com email vazio não é salvo.
     */
    @Test
    public void testSaveEmptyEmail() {
        User user = new User("", "thiagomoura");
        try {
            userService.save(user);
            Assert.fail("Uma exceção deveria ter sido lançada!");
        } catch (Exception e) {
            Assert.assertFalse("O user não deveria ter sido salvo.", userService.getAll().contains(user));
        }
    }

    /**
     * Testa se um user com username vazio não é salvo.
     */
    @Test
    public void testSaveEmptyUsername() {
        User user = new User("thiago.moura@ccc.ufcg.edu.br", "");
        try {
            userService.save(user);
            Assert.fail("Uma exceção deveria ter sido lançada!");
        } catch (Exception e) {
            Assert.assertFalse("O user não deveria ter sido salvo.", userService.getAll().contains(user));
        }
    }

    /**
     * Testa se um user com username null não é salvo.
     */
    @Test
    public void testSaveNullUsername() {
        User user = new User("thiago.moura@ccc.ufcg.edu.br", null);
        try {
            userService.save(user);
            Assert.fail("Uma exceção deveria ter sido lançada!");
        } catch (Exception e) {
            Assert.assertFalse("O user não deveria ter sido salvo.", userService.getAll().contains(user));
        }
    }

    /**
     * Testa se um user com email null não é salvo.
     */
    @Test
    public void testSaveNullEmail() {
        User user = new User(null, "thiagomoura");
        try {
            userService.save(user);
            Assert.fail("Uma exceção deveria ter sido lançada!");
        } catch (Exception e) {
            Assert.assertFalse("O user não deveria ter sido salvo.", userService.getAll().contains(user));
        }
    }

    /**
     * Testa se os users adicinados são retornados.
     */
    @Test
    public void testGetAll() {
        User user1 = new User("thiago.moura@ccc.ufcg.edu.br", "thiagomoura21");
        User user2 = new User("pedro.garcia@ccc.ufcg.edu.br", "pedrogarcia");
        User user3 = new User("emanuel.da.silva@ccc.ufcg.edu.br", "emanuelDaSilva");
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        Assert.assertTrue("Os user 1 deveria estar na lista", userService.getAll().contains(user1));
        Assert.assertTrue("Os user 2 deveria estar na lista", userService.getAll().contains(user2));
        Assert.assertTrue("Os user 3 deveria estar na lista", userService.getAll().contains(user3));
    }

    /**
     * Testa se a busca por user pelo username esta funcionando.
     */
    @Test
    public void testFindUserByUsername() {

        User user1 = this.user;
        User user2 = new User("thiago.santos@ccc.ufcg.edu.br", "thiagosantos");
        User user3 = new User("emanuel.da.silva@ccc.ufcg.edu.br", "emanuelDaSilva");
        User user4 = new User("pedro.garcia@ccc.ufcg.edu.br", "pedrogarcia");

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);

        Assert.assertEquals("Os user retornado deveria ser igual ao cadastrado", userService.findUserByUsername("thiago"), new ArrayList<>(asList(user1, user2)));
        Assert.assertEquals("Os user retornado deveria ser igual ao cadastrado", userService.findUserByUsername("emanuelDaSilva"), new ArrayList<>(asList(user3)));
        Assert.assertEquals("Os user retornado deveria ser igual ao cadastrado", userService.findUserByUsername("pedro"), new ArrayList<>(asList(user4)));
    }

    /**
     * Testa se a busca por user pelo email esta funcionando.
     */
    @Test
    public void testFindUserByEmail() {

        User user1 = this.user;
        User user2 = new User("emanuel.da.silva@ccc.ufcg.edu.br", "emanuelDaSilva");
        userService.save(user1);
        userService.save(user2);

        Assert.assertEquals("Os user retornado deveria ser igual ao cadastrado", userService.findUserByEmail("thiago.moura@ccc.ufcg.edu.br"), user1);
        Assert.assertEquals("Os user retornado deveria ser igual ao cadastrado", userService.findUserByEmail("emanuel.da.silva@ccc.ufcg.edu.br"), user2);
    }

    /**
     * Testa se o update de um user esta funcionando.
     */
    @Test
    public void testUpdate() {

        User user1 = this.user;
        User user2 = new User("emanuel.da.silva@ccc.ufcg.edu.br", "emanuelDaSilva");
        userService.save(user1);
        userService.save(user2);

        user1.setUsername("thiagomouraaaa");
        user2.setUsername("emanuelelel");

        Assert.assertEquals("Os user retornado deveria ser igual ao novo user passado", userService.update(user1), user1);
        Assert.assertEquals("Os user retornado deveria ser igual ao novo user passado", userService.update(user2), user2);
    }
}
