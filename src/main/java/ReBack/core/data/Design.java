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
public class Design {
    @SequenceGenerator(name = "design_seq_generator",
            sequenceName = "design_seq",
            initialValue = 1, allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "design_seq")
    private Long designCode;

    @Column(length=50, nullable = false)
    private String designName;

    @Column(length=1, nullable = false)
    private int designState;

    @Column(name="design_register_date", nullable = false)
    private LocalDateTime designDate;

    @Column(name="design_modification_date")
    private LocalDateTime designModification;

    @Column(name="design_attached_image_path", nullable = false)
    private String designImagePath;

    @ManyToOne
    @JoinColumn(name="category_code")
    private Category category;

    @ManyToOne
    @JoinColumn(name="material_code")
    private Material material;
}
