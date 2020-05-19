package com.nsu.bd.aircraft.api.dto.product;

import com.nsu.bd.aircraft.api.dto.company.GuildDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private GuildDto guild;

    private int engineAmount;
    private String type;
    private int chargePower;
    private int weight;

    public ProductDto(int id, GuildDto guildDto) {
        this.id = id;
        this.guild = guildDto;
    }
}
