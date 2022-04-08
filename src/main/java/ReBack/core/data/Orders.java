package ReBack.core.data;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @SequenceGenerator(name = "orders_seq_generator",
            sequenceName = "orders_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq_generator")
    private Long ordersCode;

    @Column(name="order_pay_total_amount", nullable = false, length=7)
    private int ordersTotal;

    @Column(nullable = false)
    private OrdersState ordersState;

    @Column(length=100)
    private String ordersRequest;

    @Column(name="orders_receiver_address", nullable = false)
    private String ordersAddress;

    @Column(nullable = false, length=10)
    private String ordersReceiverName;

    @Column(nullable = false, length=13, name="orders_receiver_phone_number")
    private int ordersPhoneNum;

    @Column(nullable = false, name="orders_delivery_status", length=1)
    private int ordersStatus;

    @Column(nullable = false, name="orders_delivery_company_information", length = 20)
    private String ordersDeliveryInfo;

    @ManyToOne
    @JoinColumn(name="member_code")
    private Member member;

    @ManyToOne
    @JoinColumn(name="member_design_code")
    private MemberDesign memberDesign;

    @ManyToOne
    @JoinColumn(name="pay_code")
    private Pay pay;

}
