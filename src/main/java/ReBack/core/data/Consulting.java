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
public class Consulting {
    @SequenceGenerator(name = "consulting_seq_generator",
            sequenceName = "consulting_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulting_seq_generator")
    private Long consultingCode;

    @Column(length=40, nullable = false)
    private String consultingName;

    @Column(nullable = false)
    private LocalDateTime consultingStartingTime;

    @Column(nullable = false)
    private LocalDateTime consultingEndTime;

    @Column(nullable = false, length = 50)
    private String consultingType;

    @ManyToOne
    @JoinColumn(name="member_code1")
    private Member member1;

    @ManyToOne
    @JoinColumn(name="member_code2")
    private Member member2;
}
