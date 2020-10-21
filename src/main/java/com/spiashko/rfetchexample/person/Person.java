package com.spiashko.rfetchexample.person;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spiashko.rfetchexample.cat.Cat;
import com.spiashko.rfetchexample.cat.Cat_;
import com.spiashko.rfetchexample.crudbase.entity.BaseJournalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person extends BaseJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties(Cat_.OWNER)
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private Set<Cat> kittens;

}