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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_id_seq")
    @SequenceGenerator(name = "test_id_seq", sequenceName = "test_id_seq", allocationSize = 1)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "equipment_test",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<Equipment> equipments;

    @ManyToOne
    @JoinColumn(name = "guild_id")
    private Guild guild;

    @ManyToOne
    @JoinColumn(name = "range_id")
    private Range range;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tester_id")
    private Tester tester;
}
