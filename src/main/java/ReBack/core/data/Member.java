package ReBack.core.data;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @SequenceGenerator(name = "member_seq_generator",
            sequenceName = "member_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long memberCode;

    @Column(length=30, nullable = false)
    private String memberId;

    @Column(length=10, nullable = false)
    private String memberName;

    @Column(length=30, nullable = false)
    private String memberPassword;

    @Column(length=50, nullable = false)
    private String memberEmail;

    @Column(length=11, nullable = false)
    private String memberPhoneNumber;

    @Column(length=10, nullable = false)
    private int memberPostalCode;

    @Column(nullable = false)
    private String memberAddress;

    @Column(length=10)
    private int memberPoint;

    @Column(length=20)
    private MemberHowJoin memberHowJoin;

    @Column(length=30)
    private MemberWithdrawal memberWithdrawal;

    @Column(length=10, nullable = false)
    private int memberBusinessNumber;

    @Column(length=20, nullable = false)
    private  MemberType memberType;

    @Column(nullable = false)
    private LocalDateTime memberJoinDate;

    @Column(length = 100)
    private String role="admin";



//    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL) // (1)
//    @JoinColumn(name="member_code")
//    private List<Product> products = new ArrayList<>();
}
