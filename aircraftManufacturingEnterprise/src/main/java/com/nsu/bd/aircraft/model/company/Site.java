package com.nsu.bd.aircraft.model.company;


import com.nsu.bd.aircraft.model.staff.Brigade;
import com.nsu.bd.aircraft.model.staff.Engineer;
import com.nsu.bd.aircraft.model.staff.EngineeringStaff;
import com.nsu.bd.aircraft.model.staff.Master;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "site_id_seq")
    @SequenceGenerator(name = "site_id_seq", sequenceName = "site_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "guild_id")
    private Guild guild;

    @Column(name = "work_type", nullable = false)
    private String workType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "site_manager_id", referencedColumnName = "id")
    private EngineeringStaff siteManager;

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
