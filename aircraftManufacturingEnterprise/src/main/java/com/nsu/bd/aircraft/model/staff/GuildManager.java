package com.nsu.bd.aircraft.model.staff;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "guild_manager")
public class GuildManager extends EngineeringStaff {
    public GuildManager(int id, String name, String surname) {
        super(id, name, surname);
    }
}
