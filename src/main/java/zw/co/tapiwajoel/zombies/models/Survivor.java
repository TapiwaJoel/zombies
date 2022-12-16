package zw.co.tapiwajoel.zombies.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.*;
import zw.co.tapiwajoel.zombies.utils.enums.Gender;
import zw.co.tapiwajoel.zombies.utils.enums.InventoryResources;

import java.util.Collection;


@Entity(name = "survivors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private Short age;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @OneToOne(cascade=CascadeType.ALL)
    private Location lastLocation;

    private boolean infected;

    @NotEmpty
    @ElementCollection(targetClass = InventoryResources.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "inventory_resources",
            joinColumns = @JoinColumn(name = "survivor_id")
    )
    private Collection<InventoryResources> inventoryResources;
}
