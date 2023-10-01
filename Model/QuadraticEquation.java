/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dai Nhan
 */
public class QuadraticEquation {

    private float a;
    private float b;
    private float c;

    public QuadraticEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation() {
    }

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setC(float c) {
        this.c = c;
    }

    public List<Float> calculateQuadraticEquation() {
        List<Float> listResult = new ArrayList<>();
        float d = (b * b) - (4 * a * c);
        float x1, x2;
        float delta = (float) Math.sqrt(d);
        float count;
        if (d > 0) {
            count = 1;
            x1 = (-b + delta) / (2 * a);
            x2 = (-b - delta) / (2 * a);
        } else if (d == 0) {
            count = 2;
            x1 = (-b / (2 * a));
            x2 = (-b / (2 * a));
        } else {
            count = 3;
            x1 = -1;
            x2 = -1;
        }
        listResult.add(a);
        listResult.add(b);
        listResult.add(c);
        listResult.add(x1);
        listResult.add(x2);
        listResult.add(count);
        return listResult;
    }
}
