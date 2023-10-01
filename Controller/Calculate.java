package Controller;

import Model.QuadraticEquation;
import Model.SuperlativeEquation;
import View.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dai Nhan
 */
public class Calculate extends Menu<String> {

    private Input input;
    private QuadraticEquation quadraticEquation;
    private SuperlativeEquation superlativeEquation;
    private EvenOddPerfectSquareChecker eopsChecker;
    static String[] menu = {"Superlative Equation", "Quadratic Equation", "Exit"};

    private static volatile Calculate instance = null;// khai báo biến Instance để lưu thể hiện duy nhất của lớp Calculate và ban đầu được cho là Null;
    // volatile là 1 từ khóa dùng để dánh đáu 1 biến, đảm bảo rằng giá trị biến sẽ luôn được đọc và ghi trực tiếp từ bộ nhớ chung (main memory)
    // - đảm bảo sự nhất quá và ngăn việc tái sắp sếp mã
    private Calculate() {
        super("Calculator", menu);
        this.quadraticEquation = new QuadraticEquation();
        this.superlativeEquation = new SuperlativeEquation();
        this.input = new Input();
        this.eopsChecker = new EvenOddPerfectSquareChecker();
    }

    public static Calculate getInstance() {
        if (instance == null) {
            synchronized (Calculate.class) { //đoạn này là sử dụng  double-check locking để đảm bảo nhiều luồng truy cập, tối ưu hóa hơn việc đặt synchronized trên toàn bộ phương thức, tác dụng                                           
                if (instance == null) {         // phuc vụ cho việc (lazy initialization) chỉ khởi chạy khi đc gọi chứ không chạy từ lúc bắt đàu chương trình, giảm độ trễ tăng hiệu suất
                    instance = new Calculate();
                }
            }
        }
        return instance;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        List<String> input;
        while (!exit) {
            dispplay();
            System.out.println("Input Choice:");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    input = this.input.inputSuperlativeEquation();
                    superlativeEquation.setA(Float.parseFloat(input.get(0)));
                    superlativeEquation.setB(Float.parseFloat(input.get(1)));
                    List<Float> numersResult = superlativeEquation.calculateSuperlativeEquation();
                    System.out.println("X = " + numersResult.get(2));
                    eopsChecker.isEven(numersResult);
                    eopsChecker.isOdd(numersResult);
                    eopsChecker.isPerfectSquare(numersResult);
                    break;
                case "2":
                    input = this.input.inputQuadraticEquation();
                    System.out.println(input.size());
                    quadraticEquation.setA(Float.parseFloat(input.get(0)));
                    quadraticEquation.setB(Float.parseFloat(input.get(1)));
                    quadraticEquation.setC(Float.parseFloat(input.get(2)));

                    List<Float> listResult = quadraticEquation.calculateQuadraticEquation();
                    float count = listResult.get(5);
                    listResult.remove(5);
                    if (count == 1) {
                        System.out.println("The roots of the equation are real and different");
                        System.out.println("X1 = " + listResult.get(3));
                        System.out.println("X2 = " + listResult.get(4));
                        eopsChecker.isEven(listResult);
                        eopsChecker.isOdd(listResult);
                        eopsChecker.isPerfectSquare(listResult);
                    } else if (count == 2) {
                        System.out.println("The roots of the equation are real and same");
                        System.out.println("X1 = X2 = " + listResult.get(3));
                        eopsChecker.isEven(listResult);
                        eopsChecker.isOdd(listResult);
                        eopsChecker.isPerfectSquare(listResult);
                    } else {
                        System.out.println("The roots of the equation are complex and different");
                        System.out.println("X1 = NaN");
                        System.out.println("X2 = NaN");
                        listResult.remove(4);
                        listResult.remove(3);
                        eopsChecker.isEven(listResult);
                        eopsChecker.isOdd(listResult);
                        eopsChecker.isPerfectSquare(listResult);
                    }
                    break;
                case "3":
                    System.out.println("Exit....");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
}
