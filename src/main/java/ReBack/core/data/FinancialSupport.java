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
public class FinancialSupport {
    @SequenceGenerator(name = "financial_support_seq_generator",
            sequenceName = "financial_support_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_support_seq_generator")
    private Long financialSupportCode;

    @Column(nullable = false, name="financial_support_date")
    private LocalDateTime financialDate;

    @Column(nullable = false, name="financial_support_amount")
    private int financialAmount;

    @Column(nullable = false, length=1, name="financial_support_type")
    private int financialType;

    @ManyToOne
    @JoinColumn(name="member_code")
    private Member member;
}
