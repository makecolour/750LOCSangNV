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

import java.util.ArrayList;

/**
 *
 * @author quyen
 */
public class StoreKeeperList {

    private ArrayList<StoreKeeper> keeperList = new ArrayList();
    private int lastID;

    /**
     *
     * @return
     */
    public int getLastID() {
        return lastID;
    }

    /**
     *
     * @param lastID
     */
    public void setLastID(int lastID) {
        this.lastID = lastID;
    }

    /**
     *
     */
    public StoreKeeperList() {
        keeperList.add(new StoreKeeper("Darius", 1));
        keeperList.add(new StoreKeeper("Garen", 2));
        keeperList.add(new StoreKeeper("Yasuo", 3));
        keeperList.add(new StoreKeeper("Yuumi", 4));
        keeperList.add(new StoreKeeper("Warwick", 5));
        lastID = keeperList.size();
    }

    /**
     *
     * @return
     */
    public ArrayList<StoreKeeper> getKeeperList() {
        return keeperList;
    }

    /**
     *
     * @param keeperList
     */
    public void setKeeperList(ArrayList<StoreKeeper> keeperList) {
        this.keeperList = keeperList;
    }

    void printKeeperList() {
        System.out.println("-------Store Keepers-------");
        for (StoreKeeper s : keeperList) {
            System.out.println((keeperList.indexOf(s) + 1) + ". " + s.getStoreKeeper());
        }
    }

    void addStoreKeeper(StoreKeeper sk) {
        keeperList.add(sk);
        lastID++;
    }

    boolean checkExist(StoreKeeper sk) {
        for (StoreKeeper s : keeperList) {
            if (s.getStoreKeeper().equals(sk.getStoreKeeper())) {
                return true;
            }
        }
        return false;
    }

    StoreKeeper choose() {
        Input input = new Input();
        printKeeperList();
        int choice = input.getInt("Choose a Store Keeper: ", 1, keeperList.size());
        return keeperList.get(choice - 1);
    }
}
