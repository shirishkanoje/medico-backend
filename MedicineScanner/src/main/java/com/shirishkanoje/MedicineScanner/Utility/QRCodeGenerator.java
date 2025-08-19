package com.shirishkanoje.MedicineScanner.Utility;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class QRCodeGenerator {

    private static final String QR_CODE_DIR = "src/main/resources/static/qrcodes/";

    public String generateQRCode(Long medicineId) {
        try {
            String url = "http://localhost:3000/scan/" + medicineId;


            BitMatrix bitMatrix = new MultiFormatWriter().encode(
                    url, BarcodeFormat.QR_CODE, 300, 300);

            String path = QR_CODE_DIR + "medicine_" + medicineId + ".png";
            Path outputPath = Paths.get(path);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", outputPath);

            return "/qrcodes/medicine_" + medicineId + ".png";

        } catch (Exception e) {
            throw new RuntimeException("QR Code generation failed", e);
        }
    }
}

