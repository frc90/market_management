package com.market_management.market_management.controllers;

import com.market_management.market_management.errors.LocalNotFoundException;
import com.market_management.market_management.models.Local;
import com.market_management.market_management.services.LocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalController {

    @Autowired
    private LocalService localService;

    // Getter methods
    @GetMapping("/locals")
    public List<Local> getLocals() {
        return localService.getAll();
    }

    @GetMapping("/local/{id}")
    public Local getLocalById(@PathVariable Long id) throws LocalNotFoundException {
        return localService.findById(id);
    }

    @GetMapping("/findLocalByNameWithJPQL/{name}")
    public List<Local> findLocalByNameWithJPQL(@PathVariable String name) {
        return localService.findLocalByNameWithJPQL(name);
    }

    @GetMapping("/findLocalByNameAndWithJPQL/{name}/{floor}")
    public List<Local> findLocalByNameAndWithJPQL(@PathVariable String name, @PathVariable String floor) {
        return localService.findLocalByNameAndFloorWithJPQL(name, floor);
    }

    // Post methods
    @PostMapping("/local")
    public Local addLocal(@Valid @RequestBody Local local) {
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
