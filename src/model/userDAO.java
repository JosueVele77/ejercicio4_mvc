package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class userDAO implements configurable {
    private user u;
    private File archivo;

    public userDAO() {
        super();
        initFile("user.txt");
    }
    
    public userDAO(user u_) {
        this();
        this.u = u_;
    }
    
    public boolean writeFileUser() throws IOException {
        if (u == null) {
            throw new IllegalStateException("User no puede ser null");
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path, "user.txt"), true))) {
            bw.write(u.infoUser());
            bw.newLine();
            return true;
        }
    }
    
    public List<user> getUser() throws IOException {
        List<user> users = new ArrayList<>();
        File file = new File(path, "user.txt");
        
        if (!file.exists()) {
            return users;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    users.add(new user(parts[0], parts[1], Integer.parseInt(parts[2])));
                }
            }
        }
        return users;
    }
}