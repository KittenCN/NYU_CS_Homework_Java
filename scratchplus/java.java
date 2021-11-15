package scratchplus;
import java.util.*;
public class java{
    public static void main(String[] args){
        Scanner sa = new Scanner(System.in);
        int squareLength = sa.nextInt();
        int currentNumber = 1;
        int currentLength = 1;
        int row = 0;
        int column = squareLength - 1;
        int[][] square = new int[squareLength][squareLength];
        for(int i = 0; i < 2 * squareLength - 1; i++) {
            if(currentLength < squareLength) {
                for(int j = 0; j < currentLength; j++) {
                    if(j != currentLength - 1) {
                        square[row][column] = currentNumber++;
                        row++;
                        column++;
                    }
                    else {
                        System.out.println(row + " " + column);
                        square[row][column] = currentNumber++;
                        row = 0;
                        System.out.println("22:" + squareLength + " " + currentLength);
                        column = squareLength -  currentLength;
                        System.out.println("I");
                        currentLength++;
                    }
                }
            }
            else if (currentLength == squareLength) {
                for(int k = 0; k < currentLength; k++) {
                    if(k != currentLength - 1) {
                        square[row][column] = currentNumber++;
                        row++;
                        column++;
                    }
                    else {
                        square[row][column] = currentNumber++;
                        row = 1;
                        column = 0;
                        System.out.println("II");
                        currentLength--;
                    }
                }
            }
            else {
                for(int k = 0; k < currentLength; k++) {
                    if(k != currentLength - 1) {
                        square[row][column] = currentNumber++;
                        row++;
                        column++;
                    }
                    else {
                        square[row][column] = currentNumber++;
                        row = squareLength - currentLength + 1;
                        column = 0;
                        System.out.println("III");
                        currentLength--;
                    }
                }
            }
        }
        for(int i = 0; i < squareLength; i++) {
            for(int j = 0; j < squareLength; j++) {
                if(j != squareLength - 1) {
                    System.out.print(square[i][j] + " ");
                }
                else {
                    System.out.println(square[i][j]);
                }
            }
        }
        sa.close();
    }
}