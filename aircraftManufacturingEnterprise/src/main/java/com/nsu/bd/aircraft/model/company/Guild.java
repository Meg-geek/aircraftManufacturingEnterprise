package com.nsu.bd.aircraft.model.company;


import com.nsu.bd.aircraft.model.product.Product;
import com.nsu.bd.aircraft.model.staff.EngineeringStaff;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guild_id_seq")
    @SequenceGenerator(name = "guild_id_seq", sequenceName = "guild_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "guild_name", nullable = false)
    private String guildName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private EngineeringStaff guildManager;

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

    protected Guild() {
    }

    public Guild(String guildName) {
        this.guildName = guildName;
    }

    public Guild(int id, String guildName, Company company) {
        this.id = id;
        this.guildName = guildName;
        this.company = company;
    }
}
