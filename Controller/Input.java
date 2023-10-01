/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dai Nhan
 */
public class Input {

    private Validation valid;

    public Input() {
        this.valid = new Validation();
    }

    public List<String> inputSuperlativeEquation() {
        List<String> input = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String a, b;
        do {
            System.out.println("input a: ");
            a = sc.nextLine();
            if (!valid.checkNumber(a)) {
                System.out.println("Wrong Choice!");
            }
        } while (!valid.checkNumber(a));
        input.add(a);
        do {
            System.out.println("input b: ");
            b = sc.nextLine();
            if (!valid.checkNumber(b)) {
                System.out.println("Wrong Choice!");
            }
        } while (!valid.checkNumber(b));
        input.add(b);
        return input;
    }

    public List<String> inputQuadraticEquation() {
        List<String> input = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String a, b, c;
        do {
            System.out.println("input a: ");
            a = sc.nextLine();
            if (!valid.checkNumber(a)) {
                System.out.println("Wrong Choice!");
            }
        } while (!valid.checkNumber(a));
        input.add(a);
        do {
            System.out.println("input b: ");
            b = sc.nextLine();
            if (!valid.checkNumber(b)) {
                System.out.println("Wrong Choice!");
            }
        } while (!valid.checkNumber(b));
        input.add(b);
        do {
            System.out.println("input c: ");
            c = sc.nextLine();
            if (!valid.checkNumber(c)) {
                System.out.println("Wrong Choice!");
            }
        } while (!valid.checkNumber(c));
        input.add(c);
        return input;
    }
}
