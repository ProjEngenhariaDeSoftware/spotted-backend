//package com.spotted.spotted.unidade;
//
//import com.spotted.models.Notification;
//import com.spotted.models.User;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * Testes de unidade para {@link Notification}
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class NotificationTest {
//
//    private Notification notification;
//    private User user;
//    @Before
//    public void setUp() {
//        this.user = new User("test@ccc", "NEWS", "");
//        this.notification = new Notification("NEWS", 1L, user);
//    }
//
//    /**
//     * Testa se duas notificações são iguais.
//     */
//    @Test
//    public void testEquals() {
//        Notification notification = new Notification("NEWS", 1L, this.user);
//        this.notification.setId(1L);
//        notification.setId(1L);
//        Assert.assertEquals("As notificações deveriam ser iguais.", this.notification, notification);
//    }
//
//    /**
//     * Testa se duas notificações com ids diferentes são diferentes.
//     */
//    @Test
//    public void testEqualsDifferentesNotifications() {
//        Notification notification = new Notification("NEWS", 1L, this.user);
//        this.notification.setId(1L);
//        notification.setId(2L);
//        Assert.assertNotEquals("As notificações não deveriam ser iguais.", this.notification, notification);
//    }
//
//
//}
