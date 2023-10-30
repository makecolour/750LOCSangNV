
package j1.s.p0074;
import java.util.logging.Logger;
import java.util.Scanner;

public class Calculator implements Menu {
    // ghi logger cho lớp Calculator
    private Logger logger = Logger.getLogger(Calculator.class.getName());
    @Override
    public void addtion_Matrix() {
        System.out.println("-----Addition-----");
        Scanner sc = new Scanner(System.in);
        // Nhập kích thước và dữ liệu cho ma trận thứ nhất
        System.out.print("Enter Row Matrix 1 :");
        int m = sc.nextInt();
        System.out.print("Enter Column Matrix 1 :");
        int n = sc.nextInt();
        int [][] a = input_Array(m,n,1);
        
        // Nhập kích thước và dữ liệu cho ma trận thứ hai
        System.out.print("Enter Row Matrix 2 :");
        int p = sc.nextInt();
        System.out.print("Enter Column Matrix 2 :");
        int q = sc.nextInt();
        int [][] b = input_Array(p,q,2);
        
        // Kiểm tra kích thước ma trận trước khi thực hiện phép cộng
        if(m!=p||n!=q){
            logger.warning("the two matrix cannot addition");
        }else{
            int [][] c = new int [m][n];
            System.out.println("------Result------");
            output_Array(a,m,n);
            System.out.println("+");
            output_Array(b,p,q);
            System.out.println("=");
            
            // Thực hiện phép cộng và hiển thị kết quả
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = a[i][j] + b[i][j];
                }
            }
            output_Array(c,m,n);
        }
    }
    @Override
    public void subtraction_Matrix() {
        System.out.println("-----Subtraction----- ");
        Scanner sc = new Scanner(System.in);
        
        // Nhập kích thước và dữ liệu cho ma trận thứ nhất
        System.out.print("Enter Row Matrix 1 :");
        int m = sc.nextInt();
        System.out.print("Enter Column Matrix 1 :");
        int n = sc.nextInt();
        int [][] a = input_Array(m,n,1);
        
        // Nhập kích thước và dữ liệu cho ma trận thứ hai
        System.out.print("Enter Row Matrix 2 :");
        int p = sc.nextInt();
        System.out.print("Enter Column Matrix 2 :");
        int q = sc.nextInt();
        int [][] b = input_Array(p,q,2);
        
        // Kiểm tra kích thước ma trận trước khi thực hiện phép trừ
        if(m!=p||n!=q){
            logger.warning("the two matrix cannot subtraction");
        }else{
            int [][] c = new int [m][n];
            System.out.println("------Result------");
            output_Array(a,m,n);
            System.out.println("-");
            output_Array(b,p,q);
            System.out.println("=");
            
            // Thực hiện phép trừ và hiển thị kết quả
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = a[i][j] - b[i][j];
                }
            }
            output_Array(c,m,n);
        }
    }

    @Override
    public void mutiplication_Matrix() {
        System.out.println("-----Multication----- ");
        Scanner sc = new Scanner(System.in);
        
        // Nhập kích thước và dữ liệu cho ma trận thứ nhất
        System.out.print("Enter Row Matrix 1 :");
        int m = sc.nextInt();
        System.out.print("Enter Column Matrix 1 :");
        int n = sc.nextInt();
        int [][] a = input_Array(m,n,1);
        
        // Nhập kích thước và dữ liệu cho ma trận thứ hai
        System.out.print("Enter Row Matrix 2 :");
         int p = sc.nextInt();
         System.out.print("Enter Column Matrix 2 :");
         int q = sc.nextInt();
        int [][] b = input_Array(p,q,2);
        
        // Kiểm tra kích thước ma trận trước khi thực hiện phép nhân
        if(n!=p){
            logger.warning("the two matrix cannot subtraction");
        }else{
            int [][] c = new int [m][n];
            System.out.println("------Result------");
            output_Array(a,m,n);
            System.out.println("*");
            output_Array(b,p,q);
            System.out.println("=");
            
            // Thực hiện phép nhân và hiển thị kết quả
              for (int i = 0; i < m; i++) {
                for (int j = 0; j < q; j++) {
                    c[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        c[i][j] = c[i][j] + a[i][k] * b[k][j];
                    }
                }
            }
            output_Array(c,m,q);
        }
    
}
 
    public int input_menu(){
        int m;
        while(true){
            System.out.println("=======Caculator Program=======");
            System.out.println("1. Addition matrix");
            System.out.println("2. Subtraction matrix");
            System.out.println("3. Mutiplication matrix");
            System.out.println("4. Quit");
            System.out.println("Your choice :");
            Scanner sc = new Scanner (System.in);
            try {
    
                    m = Integer.parseInt(sc.nextLine());
                    if (m <= 0) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    logger.warning("Must be input integer 1 to 4.");
                
                }
        }
        return m;
    }
    
    public int [][] input_Array(int m,int n,int k){
        Scanner sc = new Scanner (System.in);
         int [][] a = new int [m][n];
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 a[i][j]=check("Enter Matrix" +k+"["+(i+1)+"]"+"["+(j+1)+"]:");
             }
        }
         return a;
    }
    
    public int check(String a){
        Scanner sc = new Scanner (System.in);
        int m;
        while(true){
            try {
                System.out.println(a);
                    m = Integer.parseInt(sc.nextLine());
                    if (m <= 0) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Value of matrix is digit");
                }
        }
        return m;
    }
    
    public void output_Array(int [][] a, int length_of_row ,int length_of_column){
        for (int i = 0; i < length_of_row; i++) {
            for (int j = 0; j < length_of_column; j++) {
                System.out.print("["+a[i][j]+"]");
            }
            System.out.println();
        }
    }
}

