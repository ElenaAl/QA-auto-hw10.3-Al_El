package tf.qa.automation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {


        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите модификатор для формирования массива целочисленного типа (тип int)");
            int input = sc.nextInt();
            final int size = 10;

            int[] array2 = getFilledArray(size, input, (i, mod) -> i + mod);
            System.out.println(Arrays.toString(array2));

            int[] array3 = getFilledArray(size, input, (i, mod) -> i * mod);
            System.out.println(Arrays.toString(array3));

            int[] array4 = getFilledArray(size, input, (i, mod) ->  {
                if (i % 2 == 0) {
                return i / 2 + mod;
                } else {
                return (int) (Math.pow(i, 2) - mod);
            }
            });
            System.out.println(Arrays.toString(array4));

            //число=делим индекс на модификатор и умножаем на 100

            int[] array5 = getFilledArray(size, input, (i, mod) -> {
                final int mod2 = 100;
                    if (mod != 0) {
                       return  i / mod * mod2;
                    } else {
                        return i * mod2;
                    }
            });
            System.out.println(Arrays.toString(array5));

            //число=сумма индекса на модификатора, возведенных в квадрат

            int[] array6 = getFilledArray(size, input, (i, mod) -> (int) (Math.pow(i, 2) + Math.pow(mod, 2)));

            System.out.println(Arrays.toString(array6));

        } catch (Exception e) {
            System.out.println("кажется вы ввели неверные данные и потребуется запустить программу заново.");
        }
    }

    public static int[] getFilledArray(final int size, final int mod, final Process p) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = p.process(i, mod);
        }

        return array;
    }
}

