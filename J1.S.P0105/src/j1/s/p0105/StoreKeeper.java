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
 * This class represent StoreKeeper object
 *
 * @author quyen
 */
public class StoreKeeper {

    private String storeKeeper;
    private int id;

    /**
     * No parameter constructor
     *
     * @param storeKeeper
     * @param id
     */
    public StoreKeeper(String storeKeeper, int id) {
        this.storeKeeper = storeKeeper;
        this.id = id;
    }

    /**
     * Get storekeeper's name
     *
     * @return
     */
    public String getStoreKeeper() {
        return storeKeeper;
    }

    /**
     * Get storekeeper's ID
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Set StoreKeeper's name
     *
     * @param storeKeeper
     */
    public void setStoreKeeper(String storeKeeper) {
        this.storeKeeper = storeKeeper;
    }

    /**
     * Set storekeeper's ID
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}
