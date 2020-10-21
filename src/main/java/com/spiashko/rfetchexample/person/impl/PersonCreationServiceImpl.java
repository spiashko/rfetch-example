package com.spiashko.rfetchexample.person.impl;

import com.spiashko.rfetchexample.person.Person;
import com.spiashko.rfetchexample.person.PersonCreationModel;
import com.spiashko.rfetchexample.person.PersonCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class PersonCreationServiceImpl implements PersonCreationService {

    private final PersonRepository repository;
    private final PersonCreationMapper creationMapper;

    @Override
    public Person create(PersonCreationModel creationModel) {
        Person entity = creationMapper.map(creationModel);
        repository.save(entity);
        return entity;
    }

}
