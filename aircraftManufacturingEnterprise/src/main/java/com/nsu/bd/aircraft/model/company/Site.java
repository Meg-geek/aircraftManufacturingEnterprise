package com.nsu.bd.aircraft.model.company;


import com.nsu.bd.aircraft.model.staff.Brigade;
import com.nsu.bd.aircraft.model.staff.Engineer;
import com.nsu.bd.aircraft.model.staff.Master;
import com.nsu.bd.aircraft.model.staff.SiteManager;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "guild_id")
    private Guild guild;

    @Column(name = "work_type")
    private String workType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "site_manager_id", referencedColumnName = "id")
    private SiteManager siteManager;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id")
    private List<Master> masters;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id")
    private List<Brigade> brigades;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id")
    private List<Engineer> engineers;
}
