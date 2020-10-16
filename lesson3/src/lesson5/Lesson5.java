package lesson5;

import java.util.Arrays;

public class Lesson5 {
    static final int SIZE = 10_000_000;
    static final int HALF_SIZE = SIZE / 2;
    static final float[] firstArray = new float[SIZE];
    static final float[] secondArray = new float[SIZE];

    public static void main(String[] args) {
        Arrays.fill(firstArray, 1f);
        Arrays.fill(secondArray, 1f);

        long beginTime = System.nanoTime();
        calc(firstArray);
        long deltaTime = System.nanoTime() - beginTime;
        System.out.println("Один поток " + deltaTime * 1e-9f);

        beginTime = System.nanoTime();
        calcTwo(secondArray);
        deltaTime = System.nanoTime() - beginTime;
        System.out.println("Два потока " + deltaTime * 1e-9f);
    }

    static void calc(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
    }

    static void calcTwo(float[] arr) {
        final float[] a1 = new float[HALF_SIZE];
        final float[] a2 = new float[HALF_SIZE];

        System.arraycopy(arr, 0, a1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, a2, 0, HALF_SIZE);

        CalcThread threadOne = new CalcThread(a1, 0);
        CalcThread threadTwo = new CalcThread(a2, HALF_SIZE);

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(a1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(a2, 0, arr, HALF_SIZE, HALF_SIZE);
    }

}


