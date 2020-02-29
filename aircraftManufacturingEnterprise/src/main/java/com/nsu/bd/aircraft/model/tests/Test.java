package com.nsu.bd.aircraft.model.tests;

import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.product.Product;
import com.nsu.bd.aircraft.model.staff.Tester;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "test_equipment",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<Equipment> equipments;

    @ManyToOne
    private Guild guild;

    @ManyToOne
    private Range range;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Tester tester;
}
