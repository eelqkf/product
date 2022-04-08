package ReBack.core.data;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClothingSponsor {
    @SequenceGenerator(name = "clothing_sponsor_seq_generator",
            sequenceName = "clothing_sponsor_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clothing_sponsor_seq_generator")
    private Long clothingSponsorCode;

    @Column(nullable = false, name="clothing_sponsor_amount")
    private int amount;

    @Column(nullable = false, name="clothing_sponsor_pickup_date")
    private LocalDateTime pickupDate;

    @Column(nullable = false, name="clothing_sponsor_pickup_area", length = 20)
    private String pickupArea;

    @Column(name="receipt_issue_status", length=1)
    private int issueStatus;

    @Column(name="receipt_application_status", length=1)
    private int appStatus;

    @ManyToOne
    @JoinColumn(name="member_code")
    private Member member;

}
