import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;

public class Z3 {
    static double getSum(double a, double b) {
        return a + b;
    }

    static double getSubtraction(double a, double b) {
        return a - b;
    }

    static double getProduct(double a, double b) {
        return a * b;
    }

    static double getDivision(double a, double b) {
        return  a /  b;
    }



    static void writeToFile( String line) {
        try (FileWriter fw = new FileWriter("fileCalc.txt", true)) {
            fw.write(line);
            fw.write("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        LinkedList<Double> resultsList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        Scanner qst = new Scanner(System.in);
        boolean firstResultat = true;
        boolean secondResultat = false;
        double a = 0;
        double b = 0;
        while (true) {
            if (firstResultat) {
                System.out.printf("Введите первое число: ");
                a = sc.nextInt();
                resultsList.add(a);
                writeToFile("Введите первое число: " + a);
            }
            if (secondResultat || firstResultat) {

                firstResultat = false;

                System.out.printf("Введите знак операции: +, -, *, /: ");
                String signOperation = scn.nextLine();
                writeToFile("Введите знак операции: +, -, *, /: " + signOperation);

                System.out.printf("Введите второе число: ");
                b = sc.nextInt();
                writeToFile("Введите второе число: " + b);

                System.out.printf("Результат вычисления: ");
                writeToFile("Результат вычисления: ");

                switch (signOperation) {
                    case "+":
                        System.out.printf("%.2f %s %.2f = %.2f \n", a, signOperation, b, getSum(a, b));
                        writeToFile(a + " + " + b + " = " + getSum(a, b));
                        resultsList.add(getSum(a, b));
                        break;
                    case "-":
                        System.out.printf("%.2f %s %.2f = %.2f \n", a, signOperation, b, getSubtraction(a, b));
                        writeToFile(a + " - " + b + " = " + getSubtraction(a, b));
                        resultsList.add(getSubtraction(a, b));
                        break;
                    case "*":
                        System.out.printf("%.2f %s %.2f = %.2f \n", a, signOperation, b, getProduct(a, b));
                        writeToFile(a + " * " + b + " = " + getProduct(a, b));
                        resultsList.add(getProduct(a, b));
                        break;
                    case "/":
                        if (b != 0) {
                            System.out.printf("%.2f %s %.2f = %.2f \n", a, signOperation, b, getDivision(a, b));
                            writeToFile(a + " / " + b + " = " + getDivision(a, b));
                            resultsList.add(getDivision(a, b));
                        } else {
                            System.out.println("Деление на НОЛЬ!");
                            writeToFile("Деление на НОЛЬ!");
                        }
                        break;
                }
                System.out.printf("Продолжить? \n");
                System.out.printf("- да - продолжаем вычисление с полученным результатом \n");
                System.out.printf("- нет - начинаем вычисление с начала \n");
                System.out.printf("- отмена - отмена последней операции \n");
                System.out.printf("- выход - завершить работу с калькулятором \n");
                String question = qst.nextLine();
                writeToFile("Продолжить?" + question);

                switch (question) {
                    case "да":
                        a = resultsList.getLast();
                        secondResultat = true;
                        break;
                    case "нет":
                        secondResultat = false;
                        firstResultat = true;
                        break;
                    case "отмена":
                        resultsList.removeLast();
                        a = resultsList.getLast();
                        writeToFile("Последняя операция отменена");
                        break;
                    case "выход":
                        sc.close();
                        scn.close();
                        qst.close();
                        secondResultat = false;
                        break;
                }
            }
            break;
        }


    }
}