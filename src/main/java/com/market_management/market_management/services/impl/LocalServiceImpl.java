package com.market_management.market_management.services.impl;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Local;

import java.util.List;

public interface LocalServiceImpl {
    List<Local> getAll();
    Local create(Local local);
    Local findById(Long id) throws NotFoundException;
    Local update(Long id, Local local);
    String delete(Long id);
    List<Local> findLocalByNameWithJPQL(String localName);
    List<Local> findLocalByNameAndFloorWithJPQL(String localName, String floorName);
}
