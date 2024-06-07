package src;

import src.entity.User;

import java.util.Scanner;

public class Menu {
    private final UserManager userManager = new UserManager();
    public Menu() {

    }

    public void showMenu() {
        int choice = -1;
        do {
            System.out.println("----- Welcome to UserManager App----");
            System.out.println("------Please enter number to use for the app ----");
            System.out.println("1: Show list of users");
            System.out.println("2: Add new user");
            System.out.println("3: Delete user");
            System.out.println("4: Update user");
            System.out.println("5: Exit");
            System.out.println("-------------------------------------------");
            System.out.println("Please enter your choice: ");
            choice = getChoice();
            handleChoice(choice);
        } while (choice != 5);

    }

    public int getChoice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void handleChoice(int choice) {

        switch (choice) {
            case 1:
                menuShoListUser();
                break;
            case 2:
                menuAddUser();
                break;
            case 3:
                break;
            case 4:
                menuUpdateUser();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void menuShoListUser() {
        System.out.println("-------- List of users --------");
        userManager.showList();
    }

    public void menuAddUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------- User info ------");
        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter birthday(dd/mm/yy): ");
        String birthDay = scanner.nextLine();
        User user = new User(id, username, password, birthDay);
        userManager.addUser(user);
    }

    public void menuUpdateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id user update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("-------- User new info ------");
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter birthday(dd/mm/yy): ");
        String birthDay = scanner.nextLine();
        User user = new User(username, password, birthDay);
        userManager.updateUser(id, user);
    }
}
