package com.portafolio.controller;

import com.portafolio.restTemplate.ConsumoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
public class ControllerApi {

    @Autowired
    private ConsumoApi api;

    @RequestMapping(value = "/pokemon/{pokemon}", method = RequestMethod.GET)
    public ResponseEntity<?> pokemon(@PathVariable String pokemon){
        return api.consumoApi(pokemon);
    }
}
