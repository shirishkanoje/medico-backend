package com.shirishkanoje.MedicineScanner.Model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String manufacturer;
    private LocalDate expiryDate;

    private String usageInfo; // ✅ renamed from usage
    private String ageGroup;
    private String dosageInfo;

    private String qrCodeUrl;
}
