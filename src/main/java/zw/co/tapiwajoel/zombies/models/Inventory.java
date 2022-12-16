package zw.co.tapiwajoel.zombies.models;


import lombok.*;
import zw.co.tapiwajoel.zombies.utils.enums.InventoryResources;

import javax.persistence.*;

@Entity(name = "inventory_resources")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Survivor survivor;

    @Enumerated(EnumType.STRING)
    private InventoryResources inventoryResources;
}
