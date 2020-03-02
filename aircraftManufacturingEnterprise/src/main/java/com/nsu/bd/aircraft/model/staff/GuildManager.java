package com.nsu.bd.aircraft.model.staff;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity(name = "guild_manager")
public class GuildManager extends EngineeringStaff {
}
