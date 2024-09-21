import java.util.Scanner;

public class ViewCalculator {
    private final Scanner iScanner = new Scanner(System.in);
    private ICalculableFactory calculableFactory;

    public ViewCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void run() {
        while (true) {
            Complex firstArg = promptComplex("Введите первый аргумент: ");
            Calculable calculator = calculableFactory.create(firstArg);
            while (true) {
                String cmd = prompt("Выберите операцию (+, *, /, -), в случае завершения введите =): ");
                if (cmd.equals("+")) {
                    Complex arg = promptComplex("Введите второй аргумент: ");
                    calculator.sum(arg);
                    displayResult(calculator.getResult());
                    continue;
                }
                if (cmd.equals("*")) {
                    Complex arg = promptComplex("Введите второй аргумент: ");
                    calculator.multi(arg);
                    displayResult(calculator.getResult());
                    continue;
                }
                if (cmd.equals("/")) {
                    Complex arg = promptComplex("Введите второй аргумент: ");
                    calculator.div(arg);
                    displayResult(calculator.getResult());
                    continue;
                }
                if (cmd.equals("-")) {
                    Complex arg = promptComplex("Введите второй аргумент: ");
                    calculator.minus(arg);
                    displayResult(calculator.getResult());
                    continue;
                }
                if (cmd.equals("=")) {
                    displayResult(calculator.getResult());
                    break;
                }
            }
            String cmd = prompt("Продолжить работу (y/n)? ");
            if (cmd.equals("n")) {
                break;
            }
        }
        iScanner.close(); // Закрываем Scanner после использования
    }

    private void displayResult(Complex result) {
        System.out.println("====================");
        System.out.printf("Результат: %s\n", result);
        System.out.println("====================");
    }

    private String prompt(String msg) {
        System.out.print(msg);
        return iScanner.nextLine();
    }

    private double promptDouble(String msg) {
        System.out.print(msg);
        return Double.parseDouble(iScanner.nextLine());
    }

    private Complex promptComplex(String msg) {
        System.out.println(msg);
        double inputRe = promptDouble("Введите вещественную часть: ");
        double inputIm = promptDouble("Введите мнимую часть: ");
        return new Complex(inputRe, inputIm);
    }
}