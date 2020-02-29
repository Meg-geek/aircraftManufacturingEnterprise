package com.nsu.bd.aircraft.model.staff;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "guild_manager")
public class GuildManager extends EngineeringStaff{
    @Id
    @Column(name = "id_pk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPk;
}
