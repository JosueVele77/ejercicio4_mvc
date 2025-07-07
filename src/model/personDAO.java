package model;

import java.io.File;
import java.io.IOException;
import libreriaGenerica.generic;

public class personDAO implements configurable{
    private person p;
    private generic archivo=new generic();

    // Constructor para inicializar el archivo
    public personDAO() {
        super();
        init();
    }

    public personDAO(person p) {
        this.p = p;
        init();
    }
    
    public boolean writeInfoPerson() throws IOException {
        return archivo.writerFile(p.infoPerson(), false);
    }
    
    public String readInfoPerson() throws IOException {
        return archivo.readerFile();
    }
    private void init() {
    	archivo.files("C:/doc");
        archivo.create(0);  // Crear el directorio si no existe
        archivo.setFile(new File("C:/doc", "person.txt"));
        archivo.create(1);  // Crear el archivo si no existe
    }
}
