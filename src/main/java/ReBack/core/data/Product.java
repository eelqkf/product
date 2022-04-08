package ReBack.core.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
public class Product {
    @SequenceGenerator(name = "product_seq_generator",
            sequenceName = "product_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
    private Long productCode;

    @Column(nullable = false, name = "product_information")
    private String productInfo;

    @Column(nullable = false, length = 50)
    private String productName;

    @Column(nullable = false, length = 8)
    private int productPrice;

    @Column(nullable = false, length = 8)
    private int productStock;

    @Column(nullable = false)
    private String productFileName;

    @Column(nullable = false)
    private String productFilePath;

    @ManyToOne
    @JoinColumn(name = "member_code")
    private Member memberCode;

    @ManyToOne
    @JoinColumn(name = "category_code")
    private Category categoryCode;

    @ManyToOne
    @JoinColumn(name = "material_code")
    private Material materialCode;



}
