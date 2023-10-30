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

import java.io.File;

/**
 * The UserManagement class is the main class for the User Management System.
 *
 * @author Trần Đức Anh
 */
public class UserManagement {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserList u = new UserList();
        int choice = 0;
        //loop until user stop program
        do {
            System.out.print("====== USER MANAGEMENT SYSTEM ======\n"
                    + "1. Create a new account\n"
                    + "2. Login system\n"
                    + "3. Exit\n");
            choice = InputUser.getInt("your choice", 1, 3);
            switch (choice) {
                case 1:
                    u.createNewAcc();//allow user to create new user and add to the list
                    break;
                case 2:
                    u.login();//allow user to find user on database and sort student list 
                    break;
                case 3:
                    System.exit(0);//stop program
            }
        } while (true);

    }

}
