package com.market_management.market_management.services;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Manager;
import com.market_management.market_management.repositories.ManagerRepository;
import com.market_management.market_management.services.impl.ManagerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ManagerService implements ManagerRepositoryImpl {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager getManagerById(Long id) throws NotFoundException {
        Manager mg = managerRepository.findById(id).orElse(null);
        if (mg == null) {
            throw new NotFoundException("Manger not found");
        }
        return mg;
    }

    @Override
    public Manager updateManager(Long id, Manager manager) throws NotFoundException{
        Manager mg = managerRepository.findById(id).orElse(null);
        if (mg == null) {
            throw new NotFoundException("Manager not found");
        }
        if (Objects.nonNull(manager.getFirstName()) && !"".equalsIgnoreCase(manager.getFirstName())) {
            mg.setFirstName(manager.getFirstName());
        }

        if (Objects.nonNull(manager.getLastName()) && !"".equalsIgnoreCase(manager.getLastName())) {
            mg.setLastName(manager.getLastName());
        }
        managerRepository.save(mg);
        return mg;
    }

    @Override
    public String deleteManager(Long id) {
        managerRepository.deleteById(id);
        return "Manager was removed";
    }
}
