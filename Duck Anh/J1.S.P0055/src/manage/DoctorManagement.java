/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Doctor management program> :				
 * <Create a Java console program to manage doctor.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage information of Doctor.>				
 */
package manage;


/**
 * This class run program and show menu
 *
 * @author Trần Đức Anh
 */
public class DoctorManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoctorHash doctorHash = new DoctorHash();
        int choice = 0;
        //loop until user stop program
        do {
            System.out.print("================== DoctorManagement ==================\n"
                    + "1.Add Doctor\n"
                    + "2.Update Doctor.\n"
                    + "3.Delete Doctor\n"
                    + "4.Search Doctor.\n"
                    + "5.Exit.\n");
            choice = InputUser.getInt("your choice", 1, 5);
            switch (choice) {
                case 1:
                    doctorHash.addDoctor();//allow user to create new doctor and add to the list
                    break;
                case 2:
                    doctorHash.updateDoctor();//allow user to find doctor on database and sort doctor list 
                    break;
                case 3:
                    doctorHash.deleteDoctor();//allow user to update doctor information and delete doctor list 
                    break;
                case 4:
                    doctorHash.searchDoctor();//show doctor name and course belong to that doctor
                    break;
                case 5:
                    System.exit(0);//stop program
            }
        } while (true);
    }

}
