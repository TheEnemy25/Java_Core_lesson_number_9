package logos;

public class Methods {

    private double value1;
    private double value2;

    public Methods(int value1, int value2) throws IllegalAccessException, MyException {
        this.value1 = value1;
        this.value2 = value2;
        Addition();
        Subtraction();
        Multiplication();
        Division();
        IllegalArgumentException();
        ArithmeticException();
        IllegalAccessException();
        MyException();
    }

    public void Addition() {
        double res1 = value1 + value2;
        System.out.println("Результат додавання: " + res1);
    }

    public void Subtraction() {
        double res1 = value1 - value2;
        System.out.println("Результат віднімання: " + res1);
    }

    public void Multiplication() {
        double res1 = value1 * value2;
        System.out.println("Результат множення: " + res1);
    }

    public void Division() {
        double res1 = value1 / value2;
        System.out.println("Результат ділення: " + res1);
    }

    public void IllegalArgumentException() {
        if (value1 < 0 && value2 < 0) {
            throw new IllegalArgumentException("Назва помилки: IllegalArgumentException");
        }
        else {
            System.out.println("Помилки немає");
        }
    }

    public void ArithmeticException(){
        if (value1 == 0 & value2 != 0 || value1 != 0 &  value2 == 0){
            throw new ArithmeticException("Назва помилки: ArithmeticException");
        }
        else {
            System.out.println("Помилки немає");
        }
    }

    public void IllegalAccessException() throws IllegalAccessException {
        if (value1 == 0 && value2 == 0){
            throw new IllegalAccessException ("Назва помилки: IllegalAccessException");
        }
        else {
            System.out.println("Помилки немає");
        }
    }

    public void MyException() throws MyException {
        if (value1 > 0 && value2 > 0){
            throw new MyException("Назва помилки: MyException");
        }
        else {
            System.out.println("Помилки немає");
        }
    }


    @Override
    public String toString() {
        return "Methods{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
