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
public class ProductsList {

    private ArrayList<Products> prodList = new ArrayList();

    /**
     *
     */
    public ProductsList() {
    }

    /**
     *
     * @return
     */
    public ArrayList<Products> getProdList() {
        return prodList;
    }

    /**
     *
     * @param prodList
     */
    public void setProdList(ArrayList<Products> prodList) {
        this.prodList = prodList;
    }

}
