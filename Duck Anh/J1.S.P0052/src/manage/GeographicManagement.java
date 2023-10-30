/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Geography management program> :				
 * <Create a Java console program to manage geography.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage the geographic. >				
 */
package manage;

/**
 * The `GeographicManagement` class has the main method to run program
 *
 * @author Trần Đức Anh
 */
public class GeographicManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManageEastAsiaCountries o = new ManageEastAsiaCountries();
        int choice = 0;
        //loop until user stop program
        do {
            System.out.println("===================================================\n"
                    + "1. Input the information of 11 countries in East Asia\n"
                    + "2. Display the information of country you've just input\n"
                    + "3. Search the information of country by user-entered name\n"
                    + "4. Display the information of countries sorted name in ascending order\n"
                    + "5. Exit ");
            choice = InputUser.getInt("your choice", 1, 5);
            switch (choice) {
                case 1:
                    o.addCountry();//allow user to create new student and add to the list
                    break;
                case 2:
                    o.displayCountry();//allow user to find student on database and sort student list 
                    break;
                case 3:
                    o.searchCountry();//allow user to update student information and delete student list 
                    break;
                case 4:
                    o.sortCountry();//show student name and course belong to that student
                    break;
                case 5:
                    System.exit(0);//stop program
            }
        } while (true);
    }

}
