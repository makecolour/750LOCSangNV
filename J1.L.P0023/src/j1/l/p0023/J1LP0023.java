/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

/**
 * This is main class for end-user
 * @author quyen
 */
public class J1LP0023 {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Input input = new Input();
        FruitShop f = new FruitShop();
        do {
            menu.display();
            int choice = input.getInt("Please choose an option: ", 1, 4);
            switch (choice) {
                case 1:
                    f.createFruit();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    return;
            }
        } while (true);
    }
    
}
