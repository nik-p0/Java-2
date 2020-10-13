import java.lang.String;

public class lesson2 {

    static class LineException extends RuntimeException{
        LineException (int a){
            if (a < 4){
                System.out.println("Количество строк меньше 4");
            } else {
                System.out.println("Количество строк больше 4");
            }
        }

    }
    static class ColumnException extends RuntimeException{
        ColumnException(int a){
            if (a < 4){
                System.out.println("Количество столбцов меньше 4");
            } else {
                System.out.println("Количество столбцов больше 4");
            }
        }
    }
    static class NotDigit extends RuntimeException{
        NotDigit (String s){
            System.out.println("\"" + s +  "\"" + " не является цифрой");
        }
    }



    static String[][] stringSplit (String a) {
        String[] temp = a.split("\n");
        if (temp.length != 4){
            throw new LineException(temp.length);
        }


    String[][] numArray = new String[temp.length][];
        for (int i = 0; i < 4; i++) {
            numArray[i] = temp[i].split(" ");
            if (numArray[i].length != 4){
                throw new ColumnException(numArray[i].length);
            }
        }
        return numArray;
    }

    static double calc (String[][]  numArray){
        int sum = 0;
        for (int i = 0; i < numArray.length; i++) {
            for (int j = 0; j < numArray.length; j++) {
                try {
                    sum += Integer.parseInt(numArray[i][j]);
                } catch (NumberFormatException e){
                    throw new NotDigit(numArray[i][j]);
                }


            }

        }
        return (double) sum / 2;
    }


    public static void main(String[] args) {
        String original = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String moreLines = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0\n300 3 1 0";
        String lessLines = "10 3 1 2\n2 3 2 2\n5 6 7 1";
        String moreColumns = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0 1";
        String lessColumns = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1";
        String hasNotDigit = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 тест";

        String[][] numArray = stringSplit(hasNotDigit);
        System.out.println(calc(numArray));

    }
}
