package com.market_management.market_management.controllers;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Manager;
import com.market_management.market_management.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/managers")
    public List<Manager> getAll(){
        return managerService.getAllManagers();
    }

    @GetMapping("/manager/{id}")
    public Manager getManagerById(@PathVariable Long id) throws NotFoundException {
        return managerService.getManagerById(id);
    }

    @PostMapping("/manager")
    public Manager saveManager(@RequestBody Manager manager){
        return managerService.saveManager(manager);
    }

    @PutMapping("/manager/{id}")
    public Manager updateManager(@PathVariable Long id, @RequestBody Manager manager) throws NotFoundException{
        return managerService.updateManager(id, manager);
    }

    @DeleteMapping("/manager/{id}")
    public String deleteManager(@PathVariable Long id){
        return managerService.deleteManager(id);
    }
}
