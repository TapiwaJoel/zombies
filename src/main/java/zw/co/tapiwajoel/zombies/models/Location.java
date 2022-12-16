package zw.co.tapiwajoel.zombies.models;

import javax.persistence.*;
import lombok.*;

@Entity(name = "locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private double latitude;

    @NonNull
    private double longitude;
}
