/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

/**
 *
 * @author quyen
 */
public class J1LP0021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Input input = new Input();
        StudentsManagement sm = new StudentsManagement();
        do {
            menu.display();
            int choice = input.getInt("Please choose an option: ", 1, 5);
            switch (choice) {
                case 1:
                    sm.createStudent();
                    break;
                case 2:
                    sm.findNSort();
                    break;
                case 3:
                    sm.upNDel();
                    break;
                case 4:
                    sm.report();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
}
