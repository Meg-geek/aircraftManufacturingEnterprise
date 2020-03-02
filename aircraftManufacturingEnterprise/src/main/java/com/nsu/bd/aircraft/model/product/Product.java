package com.nsu.bd.aircraft.model.product;

import com.nsu.bd.aircraft.model.company.Guild;
import com.nsu.bd.aircraft.model.tests.Test;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "guild_id")
    private Guild guild;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private List<Test> tests;
}
