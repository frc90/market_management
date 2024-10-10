package com.market_management.market_management.services;

import com.market_management.market_management.errors.NotFoundException;
import com.market_management.market_management.models.entities.Local;
import com.market_management.market_management.repositories.LocalRepository;
import com.market_management.market_management.services.impl.LocalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalService implements LocalServiceImpl {

    @Autowired
    private LocalRepository localRepository;

    public List<Local> getAll() {
        return localRepository.findAll();
    }

    @Override
    public Local create(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local findById(Long id) throws NotFoundException {
        Optional<Local> local = localRepository.findById(id);
        if (local.isEmpty()) {
            throw new NotFoundException("Local is not available");
        }
        return local.get();
    }

    @Override
    public Local update(Long id, Local local) {
        Local lc = localRepository.findById(id).orElse(null);
        if (lc == null) {
            return null;
        }
        if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
            lc.setName(local.getName());
        }
        if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            lc.setCode(local.getCode());
        }
        if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
            lc.setFloor(local.getFloor());
        }
        return localRepository.save(lc);
    }

    @Override
    public String delete(Long id) {
        localRepository.deleteById(id);
        return "Local was removed!";
    }

    @Override
    public List<Local> findLocalByNameWithJPQL(String localName) {
        return localRepository.findLocalByNameWithJPQL(localName);
    }

    @Override
    public List<Local> findLocalByNameAndFloorWithJPQL(String localName, String floorName) {
        return localRepository.findLocalByNameAndFloorWithJPQL(localName, floorName);
    }
}
