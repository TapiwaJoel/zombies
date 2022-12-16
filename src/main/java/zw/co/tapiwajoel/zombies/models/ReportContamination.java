package zw.co.tapiwajoel.zombies.models;


import lombok.*;

import javax.persistence.*;

@Entity(name = "contamination_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReportContamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Survivor survivor;

    private int numberOfReports;
}
