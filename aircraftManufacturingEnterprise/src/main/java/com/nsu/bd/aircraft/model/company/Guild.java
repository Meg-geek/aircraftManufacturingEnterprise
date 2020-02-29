package com.nsu.bd.aircraft.model.company;


import com.nsu.bd.aircraft.model.product.Product;
import com.nsu.bd.aircraft.model.staff.EngineeringStaff;
import com.nsu.bd.aircraft.model.staff.GuildManager;
import com.nsu.bd.aircraft.model.tests.Range;
import com.nsu.bd.aircraft.model.tests.Test;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "guild")
public class Guild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "id_pk")
    private GuildManager guildManager;

    //полигоны
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "test",
            joinColumns = @JoinColumn(name = "guild_id"),
            inverseJoinColumns = @JoinColumn(name = "range_id"))
    private List<Range> ranges;

    //участки
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_id")
    private List<Site> sites;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_id")
    private List<Product> products;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_id")
    private List<Test> tests;
}
