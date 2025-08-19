package com.shirishkanoje.MedicineScanner.Service;

import com.shirishkanoje.MedicineScanner.Model.Medicine;
import com.shirishkanoje.MedicineScanner.Repository.MedicineRepository;
import com.shirishkanoje.MedicineScanner.Utility.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;
    private final QRCodeGenerator qrCodeGenerator;

    @Override
    public Medicine createMedicine(Medicine medicine) {
        Medicine saved = medicineRepository.save(medicine);
        String qrPath = qrCodeGenerator.generateQRCode(saved.getId());
        saved.setQrCodeUrl(qrPath);
        return medicineRepository.save(saved);
    }

    @Override
    public Medicine updateMedicine(Long id, Medicine updated) {
        Medicine existing = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
        existing.setName(updated.getName());
        existing.setManufacturer(updated.getManufacturer());
        existing.setExpiryDate(updated.getExpiryDate());
        existing.setUsageInfo(updated.getUsageInfo());
        existing.setAgeGroup(updated.getAgeGroup());
        existing.setDosageInfo(updated.getDosageInfo());
        return medicineRepository.save(existing);
    }

    @Override
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }
}
