package src;
import src.entity.User;
import src.impl.Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UserManager implements Manager {
    private List<User> users;
    private final String PATH_FILE = "data.txt";
    public UserManager() {
        this.users = new ArrayList<>();
        try {
            this.users = readDataFromFile();
        } catch (IOException e) {
            System.out.println("Error initializing user data: " + e.getMessage());
        }
    }
    @Override
    public void addUser(User user) {
        try {
            this.users.add(user);
            writeAllDataToFile(this.users);
        } catch (IOException e) {
            System.out.println("Error adding user: " + e.getMessage());
        }
    }
    @Override
    public void showList() {
        for (User user : this.users) {
            System.out.println(user);
        }
    }
    @Override
    public void deleteUser(int id) {
        try {
            List<User> updatedUsers = new ArrayList<>();
            for (User user : this.users) {
                if (user.getId() != id) {
                    updatedUsers.add(user);
                }
            }
            this.users = updatedUsers;
            writeAllDataToFile(this.users);
        } catch (IOException e) {
            System.out.println("Error deleting user: " + e.getMessage());
        }
    }
    @Override
    public void updateUser(int id, User user) {
        try {
            for (User item : this.users) {
                if (item.getId() == id) {
                    item.setUsername(user.getUsername());
                    item.setPassword(user.getPassword());
                    item.setBirthDay(user.getBirthDay());
                }
            }
            writeAllDataToFile(this.users);
        } catch (IOException e) {
            System.out.println("Error updating user: " + e.getMessage());
        }
    }
    private List<User> readDataFromFile() throws IOException {
        File myFile = new File(PATH_FILE);
        if (!myFile.exists()) {
            throw new FileNotFoundException("File not found: " + PATH_FILE);
        }
        List<User> listUsers = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    try {
                        int id = Integer.parseInt(data[0]);
                        String username = data[1];
                        String password = data[2];
                        String birthDay = data[3];
                        User user = new User(id, username, password, birthDay);
                        listUsers.add(user);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
        }
        return listUsers;
    }
    private void writeAllDataToFile(List<User> users) throws IOException {
        File myFile = new File(PATH_FILE);
        if (!myFile.exists()) {
            myFile.createNewFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFile))) {
            for (User user : users) {
                writer.write(user.getId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getBirthDay());
                writer.newLine();
            }
        }
    }
}
