package JavaProjects.HM1_4;

import java.util.Scanner;

    /*
     * 4. Реализовать простой калькулятор 
     * ("введите первое число"... "Введите второе число"...
     *  "укажите операцию, которую надо выполнить с этими числами"...
     *  "ответ: ...")
     */

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        String oper = scanner.next();
        int num2 = scanner.nextInt();
        System.out.println(num1 + " " + oper + " " + num2);
        System.out.println(calc(num1, num2, oper));
        
    }
    public static int calc(int num1, int num2, String operation){
        int result;
        switch (operation){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, operation);//рекурсия
        }
        return result;
    }
    
}
