/*							
 * Copyright(C) 2023,  FPT University.							
 * Products management system							
 * Manage information of Products					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-24>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Products using List>							
 */
package j1.s.p0105;

/**
 *
 * @author quyen
 */
public class ProductsManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Input input = new Input();
        ManageProducts mp = new ManageProducts();
        do {
            menu.display();
            int choice = input.getInt("Please choose an option: ", 1, 6);
            switch (choice) {
                case 1:
                    mp.addStoreKeeper();
                    break;
                case 2:
                    mp.addProduct();
                    break;
                case 3:
                    mp.updateProduct();
                    break;
                case 4:
                    mp.searchByOthers();
                    break;
                case 5:
                    mp.sortProduct();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }
}
