package com.spiashko.rfetchexample.cat.impl;

import com.spiashko.rfetchexample.cat.Cat;
import com.spiashko.rfetchexample.cat.CatCreationModel;
import com.spiashko.rfetchexample.cat.CatCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Service
class CatCreationServiceImpl implements CatCreationService {

    private final CatRepository repository;
    private final CatCreationMapper creationMapper;
    private final EntityManager entityManager;

    @Override
    public Cat create(CatCreationModel creationModel) {
        Cat entity = creationMapper.map(creationModel, entityManager);
        repository.save(entity);
        return entity;
    }

}
