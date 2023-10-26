/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0023;

import java.util.logging.Logger;

/**
 *
 * @author quyen
 */
public class FruitShop {
    private static final Logger LOG = Logger.getLogger(FruitShop.class.getName());
    Original o = new Original();
    FruitsList fl = new FruitsList();
    Input input = new Input();
    private Fruit findById(String id)
    {
        if(fl.getFruitList().isEmpty())
        {
            return null;
        }
        else
        {
            for(Fruit f : fl.getFruitList())
            {
                if(f.getId().equalsIgnoreCase(id))
                {
                    return f;
                }
            }
            return null;
        }
    }
    private Nation chooseOrigin()
    {
        for(Nation n :o.getOrigin())
        {
            System.out.println((o.getOrigin().indexOf(n)+1)+". "+n.getNation());
        }
        int n = input.getInt("Choose origin: ", 1, o.getOrigin().size());
        return o.getOrigin().get(n-1);
    }
    private void addToList()
    {
        String id = input.getString("ID: ", "", "");
        if(findById(id)!=null)
        {
            LOG.warning("Fruit is already exist");
            return;
        }
        String name = input.getString("Name: ", "", "");
        double price = input.getDouble("Price: ");
        int quantity = input.getInt("Quantity: ", 0, Integer.MAX_VALUE);
        Nation origin = chooseOrigin();
        Fruit add = new Fruit(id, name, price, quantity, origin);
        fl.getFruitList().add(add);
    }
    void createFruit()
    {  
        while (true) {
            addToList();
            char choice = input.getString("Do you want to continue Y/N? ", "", "").charAt(0);
            if (choice == 'Y' || choice == 'y') {
                break;
            } else if (choice == 'N' || choice == 'n') {
                return;
            }
        }
    }
    void 
}
