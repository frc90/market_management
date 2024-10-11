package com.market_management.market_management.services.impl;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Manager;

import java.util.List;

public interface ManagerRepositoryImpl {
    List<Manager> getAllManagers();
    Manager saveManager(Manager manager);
    Manager getManagerById(Long id) throws NotFoundException;
    Manager updateManager(Long id, Manager manager) throws NotFoundException;
    String deleteManager(Long id);
}
