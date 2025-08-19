package com.shirishkanoje.MedicineScanner.Controller;

import com.shirishkanoje.MedicineScanner.Model.Medicine;
import com.shirishkanoje.MedicineScanner.Service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class QRScanController {

    private final MedicineService medicineService;

    @GetMapping("/scan/{id}")
    public ResponseEntity<Medicine> scanMedicine(@PathVariable Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        return ResponseEntity.ok(medicine);

    }


}
