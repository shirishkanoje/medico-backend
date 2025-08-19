package com.shirishkanoje.MedicineScanner.Service;

import com.shirishkanoje.MedicineScanner.Model.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine createMedicine(Medicine medicine);
    Medicine updateMedicine(Long id, Medicine updated);
    void deleteMedicine(Long id);
    Medicine getMedicineById(Long id);
    List<Medicine> getAllMedicines();
}
