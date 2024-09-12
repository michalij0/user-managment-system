import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserManagementApp {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1: Add User");
            System.out.println("2: List Users");
            System.out.println("3: Update User");
            System.out.println("4: Delete User");
            System.out.println("5: Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();

                        User newUser = new User();
                        newUser.setUsername(username);
                        newUser.setPassword(password);
                        newUser.setEmail(email);

                        userService.addUser(newUser);
                        System.out.println("User added successfully.");
                        break;
                    case 2:
                        List<User> users = userService.getAllUsers();
                        for (User user : users) {
                            System.out.println("ID: " + user.getId() +
                                    ", Username: " + user.getUsername() +
                                    ", Email: " + user.getEmail());
                        }
                        break;
                    case 3:
                        System.out.print("Enter user ID to update: ");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();

                        User updateUser = new User();
                        updateUser.setId(updateId);
                        updateUser.setUsername(newUsername);
                        updateUser.setPassword(newPassword);
                        updateUser.setEmail(newEmail);

                        userService.updateUser(updateUser);
                        System.out.println("User updated successfully.");
                        break;
                    case 4:
                        System.out.print("Enter user ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        userService.deleteUser(deleteId);
                        System.out.println("User deleted successfully.");
                        break;
                    case 5:
                        System.exit(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}