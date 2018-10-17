package com.spotted.controllers;

import com.spotted.models.Spotted;
import com.spotted.services.SpottedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class SpottedController {

    @Autowired
    SpottedService spottedService;

    @RequestMapping(value = "/spotted", method = RequestMethod.POST)
    public Spotted save(@RequestBody Spotted spotted) {
        return this.spottedService.save(spotted);
    }
}
