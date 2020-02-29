package com.nsu.bd.aircraft.model.staff;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "brigade")
public class Brigade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foreman_id", referencedColumnName = "id")
    private Worker foreman;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "brigade_id")
    private List<Worker> workers;
}
