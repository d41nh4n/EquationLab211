/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class EvenOddPerfectSquareChecker {

    public EvenOddPerfectSquareChecker() {
    }

    public void isEven(List<Float> numbers) {
        List<Float> listEven = new ArrayList<>();
        for (Float number : numbers) {
            if (number % 2 == 0 && number != 0.0) {
                listEven.add(number);
            }
        }
        if (listEven.isEmpty()) {
            System.out.println("Null");
        } else {
            System.out.println("Even numbers: " + listEven);
        }
    }

    public void isOdd(List<Float> numbers) {
        List<Float> listOdd = new ArrayList<>();
        for (Float number : numbers) {
            if (number % 2 != 0 && number != 0.0) {
                listOdd.add(number);
            }
        }
        if (listOdd.isEmpty()) {
            System.out.println("Null");
        } else {
            System.out.println("Odd number: " +listOdd);
        }
    }

    public void isPerfectSquare(List<Float> numbers) {
        List<Float> isPerfectSquare = new ArrayList<>();
        for (Float number : numbers) {
            if (Math.sqrt((double) number) % 2 == 0 && number != 0.0) {
                isPerfectSquare.add(number);
            }
        }
        if (isPerfectSquare.isEmpty()) {
            System.out.println("Perfect Square numbers: Null");
        } else {
            System.out.println("Perfect Square numbers: " + isPerfectSquare);
        }
    }
}
