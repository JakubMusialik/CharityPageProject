package pl.coderslab.charity.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Min(1)
    @NotNull
    @Column(nullable = false)
    private Integer quantity;

    @NotEmpty
    @ManyToMany
    private List<Category> categoryList = new ArrayList<>();

    @NotNull
    @ManyToOne
    private Institution institution;

    @Pattern(regexp = "[A-Za-z0-9-\\s\\D]{2,30}")
    @NotBlank
    @Column(nullable = false)
    private String street;

    @Pattern(regexp = "[A-Za-z-]{2,20}")
    @NotBlank
    @Column(nullable = false)
    private String city;

    @Pattern(regexp = "[0-9]{9}")
    @NotBlank
    @Column(nullable = false)
    private String phoneNumber;

    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]")
    @NotBlank
    @Column(nullable = false)
    private String zipCode;

    @Future
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate pickUpDate;

    @NotNull
    @Column(nullable = false)
    private LocalTime pickUpTime;

    @Length(max=255)
    @Column
    private String pickUpComment;

    public Donation(
            int quantity,
            List<Category> categoryList,
            Institution institution,
            String street,
            String city,
            String phoneNumber,
            String zipCode,
            LocalDate pickUpDate,
            LocalTime pickUpTime,
            String pickUpComment) {

        this.quantity = quantity;
        this.categoryList = categoryList;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }
}
