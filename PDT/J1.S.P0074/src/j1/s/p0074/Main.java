
package j1.s.p0074;
import java.util.logging.Logger;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Calculator a = new Calculator();
        int num;
        do{
            num = a.input_menu();
            switch(num){
                case 1: a.addtion_Matrix();
                        break;
                case 2: a.subtraction_Matrix();
                        break;
                case 3: a.mutiplication_Matrix();
                        break;
                case 4: break;
                
                default:{
                    logger.warning("Must be input integer 1 to 4.");
                }
            }
        }while(num>4);
    }
}
