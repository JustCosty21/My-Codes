public class MyMath
{
    private int firstNumber, secondNumber ;
    public MyMath(int number1, int number2)
      {
        firstNumber = number1 ;
        secondNumber = number2 ;
      }//MyMath
    
    //calculating greatestCommonDivisor
    public static int greatestCommonDivisor(int number1, int number2)
      {
        while(number1 != number2)
          if(number1 > number2)
            number1 = number1 - number2 ;
          else
            number2 = number2 - number1 ;
        return number1 ;
      }//greatestCommonDivisor
}//MyMath
