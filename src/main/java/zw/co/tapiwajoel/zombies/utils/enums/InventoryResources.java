package zw.co.tapiwajoel.zombies.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InventoryResources {
    WATER("WATER"),
    FOOD("FOOD"),
    MEDICATION("MEDICATION"),
    AMMUNITION("AMMUNITION");

    private final String inventoryResource;
}
