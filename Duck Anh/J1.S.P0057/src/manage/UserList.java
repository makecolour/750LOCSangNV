
/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <User management system.> :				
 * <Create a Java console program to manage User.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-10-09>      <8.2>     <AnhTD>        <Write a program to manage information of User.>				
 */
package manage;

import entity.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The UserList class manages a list of User objects and provides methods for
 * user management.
 *
 * @author Trần Đức Anh
 */
public class UserList {

    private static final Logger logger = Logger.getLogger(UserList.class.getName());
    private ArrayList<User> userList;

    /**
     * Default constructor for the UserList class. Initializes userList and
     * loads data from a file.
     */
    public UserList() {
        userList = new ArrayList<>();
        loadfromFile();
    }   

    /**
     * Constructor for the UserList class that initializes it with a given
     * ArrayList of User objects.
     *
     * @param userList The ArrayList of User objects to initialize the UserList
     * with.
     */
    public UserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    /**
     * Load user data from a file and populate the userList.
     */
    private void loadfromFile() {
        String line = null;
        String[] attribute = null;
        try {
            File file = new File("user.dat");
            file.createNewFile();
            FileReader fileReader = new FileReader(file);
            BufferedReader fileBuffer = new BufferedReader(fileReader);
            do {
                line = fileBuffer.readLine();
                if (line == null) {
                    break;
                }
                attribute = line.split("-");
                userList.add(new User(attribute[0], attribute[1]));
            } while (true);
            fileBuffer.close();
            fileReader.close();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error loadFromFile");
        }
    }

    /**
     * Display the list of users.
     */
    public void show() {
        //userList.clear();
        //loadfromFile();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * Create a new user account and save it to the userList and file.
     */
    public void createNewAcc() {
        String text = null;
        User newUser = new User(InputUser.getUsername(userList, "username", text, 1), InputUser.getPassword(userList, "password", text, 1));
        userList.add(newUser);
        saveToFile(newUser);
    }

    /**
     * Perform user login and display a message if successful.
     */
    public void login() {
        String text = null;
        if (InputUser.getUsername(userList, "user name to login", text, 0) != null && InputUser.getPassword(userList, "password to login", text, 0) != null) {
            System.err.println("Login successfull");
        }
    }

    /**
     * Save a User object to the file.
     *
     * @param user The User object to be saved.
     */
    private void saveToFile(User user) {
        String line = null;
        try {
            File file = new File("user.dat");
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter fileBuffer = new BufferedWriter(fileWriter);
            line = user.getUsername() + "-" + user.getPassword();
            fileBuffer.write(line);
            fileBuffer.close();
            fileWriter.close();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error loadFromFile", e);
        }
    }
}
