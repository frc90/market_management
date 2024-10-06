package com.market_management.market_management.services;

import com.market_management.market_management.models.Local;

import java.util.List;

public interface LocalServiceImpl {
    List<Local> getAll();
    Local create(Local local);
    Local findById(Long id);
    Local update(Long id, Local local);
    String delete(Long id);
    List<Local> findLocalByNameWithJPQL(String localName);
    List<Local> findLocalByNameAndFloorWithJPQL(String localName, String floorName);
}
