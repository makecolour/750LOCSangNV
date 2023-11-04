/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package person_p0063;

import java.util.ArrayList;

/**
 * This class provides methods for inputting data
 *
 * @author Chu Hoang Giang
 */
public class Manager {
    private final ArrayList<Person> personList = new ArrayList<>();
    private final Scan sc = new Scan();
    /**
     * Add new person to the list
     */
    public void addNewPer() {
        int count = 1;
        do {            
            System.out.println("Input information of Person " + count);
            String name = sc.nextLine("Ente name: ");
            String address = sc.nextLine("Enter address: ");
            double salary = sc.nextDouble("Enter salary: ");
            count++;
            System.err.println("Add sucessfully");
            personList.add(new Person(name, address, salary));
        } while (sc.checkApprove("Do you want to add more? (Y/N): "));
        System.out.println("\n");
    }
    /**
     * display the list
     */
    public void display() {
        sortBySalary();
        System.out.println("Information of Person\n ");
        System.out.printf("%-20s%-20s%-20s%n", "Name", "Address", "Salary");
        for(Person data : personList) {
            System.out.printf("%-20s%-20s%-20s%n", data.getName(), data.getAddress(), data.getSalary());
            
        }
    }
    
    /**
     * sort the list by salary
     */
    public void sortBySalary() {
        for (int i = 0; i < personList.size() - 1; i++) {
            for (int j = 0; j < personList.size() - 1 - i; j++) {
                if(personList.get(j).getSalary() > personList.get(j+1).getSalary()) {
                    Person temp = personList.get(j);
                    personList.set(j, personList.get(j + 1));
                    personList.set(j + 1, temp);
                }
            }
        }
    }
}
