package com.spiashko.rfetchexample.web.rest;

import com.spiashko.rfetchexample.person.Person;
import com.spiashko.rfetchexample.person.PersonCreationModel;
import com.spiashko.rfetchexample.person.PersonCreationService;
import com.spiashko.rfetchexample.person.PersonSearchService;
import com.spiashko.rfetchexample.rfetch.RfetchSpec;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonRestController {

    private final PersonCreationService creationService;
    private final PersonSearchService searchService;

    @PostMapping
    public Person create(@RequestBody PersonCreationModel createRequest) {
        Person result = creationService.create(createRequest);
        return result;
    }

    @GetMapping
    public List<Person> findAll(
            @Parameter(hidden = true)
            @RfetchSpec Specification<Person> spec
    ) {
        List<Person> result = searchService.findAll(spec);
        return result;
    }

}
