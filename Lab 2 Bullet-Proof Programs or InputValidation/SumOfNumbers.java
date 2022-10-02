public class SumOfNumbers {
    public static int sumOfNumbers(String str){
        int sum = 0;
        for(int i = 0; i <= str.length() - 1; ++i){
            if(Character.isDigit(str.charAt(i))){
                sum += Integer.parseInt(str.substring(i, i + 1));
            }
        }
        return sum;
    }
}
