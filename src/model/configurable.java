package model;

import java.io.File;
import java.io.IOException;

public interface configurable {
    public final String path = "doc/";
    
    // Elimina la inicialización automática aquí
    public default void initFile(String nameFile) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(path, nameFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}