package com.spiashko.rfetchexample.person.impl;

import com.spiashko.rfetchexample.person.Person;
import com.spiashko.rfetchexample.person.PersonCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class PersonCreationServiceImpl implements PersonCreationService {

    private final PersonRepository repository;

    @Override
    public Person create(Person entityToCreate) {
        Person entity = repository.save(entityToCreate);
        return entity;
    }

}
