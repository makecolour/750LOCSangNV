/*							
 * Copyright(C) 2023,  FPT University.							
 * Ebank System							
 * Manage login process					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-21>       <1.0>          <Nguyen Thuong Quyen>     <Manage login process and display in language>							
 */
package j1.s.p0070;

import java.util.ArrayList;

/**
 * This class contains a list of existed account for testing the program
 *
 * @author quyen
 */
class AccountList {

    ArrayList<Account> accList = new ArrayList<>();

    public AccountList() {
        accList.add(new Account("0123456789", "123456ab"));
        accList.add(new Account("8888888888", "abcd1234"));
        accList.add(new Account("1111111111", "1234abcd"));
    }
}
