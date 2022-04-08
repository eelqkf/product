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
public class MemberDesign {
    @SequenceGenerator(name = "member_design_seq_generator",
            sequenceName = "member_design_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_design_seq_generator")
    private Long memberDesignCode;

    @Column(name="member_design_name", length=50, nullable = false)
    private String designName;

    @Column(name="memer_design_open_status", length=1, nullable = false)
    private int designStatus;

    @Column(name="member_design_image_path", nullable = false)
    private String designPath;

    @Column(name="member_design_update_date")
    private LocalDateTime designDate;

    @Column(name="member_design_registration_date")
    private LocalDateTime designRegistrationDate;

    @ManyToOne
    @JoinColumn(name="design_code")
    private Design design;

    @ManyToOne
    @JoinColumn(name="member_code")
    private Member member;
}
