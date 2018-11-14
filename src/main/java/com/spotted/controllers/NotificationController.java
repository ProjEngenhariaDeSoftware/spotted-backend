package com.spotted.controllers;

import com.spotted.models.Notification;
import com.spotted.services.NotificationService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.PUT)
    public Notification viewNotification(@PathVariable Long id) {
        return this.notificationService.viewNotification(id);
    }
}
