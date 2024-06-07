package src.impl;

import src.entity.User;

public interface Manager {
    void addUser(User user);
    void showList();
    void deleteUser(int id);
    void updateUser(int id, User user);
}
