package com.spiashko.rfetchexample.cat;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.spiashko.rfetchexample.crudbase.View;
import com.spiashko.rfetchexample.crudbase.entity.BaseJournalEntity;
import com.spiashko.rfetchexample.person.Person;
import com.spiashko.rfetchexample.person.Person_;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cat")
public class Cat extends BaseJournalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @JsonView({View.Retrieve.class, View.Update.class, View.Create.class})
    @NotEmpty
    @Column(name = "name")
    private String name;

    @JsonView({View.Retrieve.class, View.Update.class, View.Create.class})
    @NotNull
    @Column(name = "dob")
    private LocalDate dob;

    @JsonView({View.Retrieve.class, View.Update.class, View.Create.class})
    @NotNull
    @JsonIgnoreProperties(Person_.KITTENS)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_owner")
    private Person owner;

    @JsonView({View.Retrieve.class, View.Create.class})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_parent", updatable = false)
    private Cat parent;

    @JsonView({View.Retrieve.class})
    @JsonIgnoreProperties(Cat_.PARENT)
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<Cat> kids;

}
