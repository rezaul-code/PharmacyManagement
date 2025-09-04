package com.rx.pharmacy.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

public class DatabaseInitializer {

    public static void init() throws IOException {
        String userHome = System.getProperty("user.home");
        Path dbPath = Paths.get(userHome, "AppData", "Local", "PharmacyApp", "data", "pharmacy.db");

        // Ensure folder exists
        if (!Files.exists(dbPath.getParent())) {
            Files.createDirectories(dbPath.getParent());
        }

        // Copy default DB from resources if not exists
        if (!Files.exists(dbPath)) {
            try (InputStream in = DatabaseInitializer.class.getResourceAsStream("/data/pharmacy.db")) {
                if (in != null) {
                    Files.copy(in, dbPath);
                    System.out.println("✅ Copied default DB to: " + dbPath);
                } else {
                    Files.createFile(dbPath);
                    System.out.println("⚠️ Created new empty DB at: " + dbPath);
                }
            }
        }
    }
}
