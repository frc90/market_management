package com.market_management.market_management.controllers;

import com.market_management.market_management.models.Local;
import com.market_management.market_management.services.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping("/locals")
    public List<Local> getLocals() {
        return localService.getAll();
    }

    @GetMapping("/local/{id}")
    public Local getLocalById(@PathVariable Long id) {
        return localService.findById(id);
    }

    @PostMapping("/local")
    public Local addLocal(@RequestBody Local local) {
        return localService.create(local);
    }

    @PutMapping("/local/{id}")
    public Local updateLocal(@PathVariable Long id, @RequestBody Local local) {
        return localService.update(id, local);
    }

    @DeleteMapping("/local/{id}")
    public String deleteLocal(@PathVariable Long id) {
        return localService.delete(id);
    }
}
