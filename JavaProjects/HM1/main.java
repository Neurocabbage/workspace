package JavaProjects.HM1;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        //final Scanner scanner = new Scanner(System.in);

        //int n = scanner.nextInt();
 
        System.out.println(getPrimes());
        
    }
    /*
     * 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n)
     */
    public static int sumInRange(int n) {
        int result =0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
    /*
     * 2. Вычислить n! (произведение чисел от 1 до n)
     */
    public static int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
           result *= i;
        }
        return result;
      }
    /*
     * 3. Вывести все простые числа от 1 до 1000 
     * (простые числа - это числа которые делятся только на себя и на единицу без остатка. 
     * Чтобы найти остаток от деления используйте оператор % ,
     *  например 10%3 будет равно единице)
     */
    public static ArrayList<Integer> getPrimes() {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int i = 2; i < 1000; ++i){
            int count = 0;
            for(int j = 2; j <=i && count < 2;++j){
              if(i%j==0){
                ++count;
              }
            }
            if(count<2)
               primes.add(i);
          }
        return primes;
       
      }     


}
