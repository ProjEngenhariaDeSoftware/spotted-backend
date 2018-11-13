package com.spotted.controllers;

import com.spotted.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.notificationService.delete(id);
    }
}
