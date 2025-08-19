package com.shirishkanoje.MedicineScanner.Controller;

import com.shirishkanoje.MedicineScanner.Model.Medicine;
import com.shirishkanoje.MedicineScanner.Service.MedicineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/medicines")
@RequiredArgsConstructor
public class AdminMedicineController {

    private final MedicineService medicineService;

    @PostMapping("/create")
    public ResponseEntity<Medicine> createMedicine(@RequestBody @Valid Medicine medicine) {
        return ResponseEntity.ok(medicineService.createMedicine(medicine));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine updated) {
        return ResponseEntity.ok(medicineService.updateMedicine(id, updated));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.ok("Medicine deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicine(@PathVariable Long id) {
        return ResponseEntity.ok(medicineService.getMedicineById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Medicine>> getAll() {
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }
}

