import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.JButton ;
import javax.swing.JLabel ;
import javax.swing.JFrame ;
import javax.swing.JTextField ;

//Calculates the GCD of 3 numbers

public class GCD extends JFrame implements ActionListener
  {

    //creates a text field for each number and for the result

    private final JTextField number1JTextField = new JTextField(20) ;
    private final JTextField number2JTextField = new JTextField(20) ;
    private final JTextField number3JTextField = new JTextField(20) ;
    private final JTextField resultJTextField = new JTextField(20) ;

    //Constructor

    public GCD()
      {
        setTitle("GCD") ;
        Container contents = getContentPane() ;
        contents.setLayout(new GridLayout(0, 1)) ;

        contents.add(new JLabel("Number 1")) ;
        contents.add(number1JTextField) ;

        contents.add(new JLabel("Number 2")) ;
        contents.add(number2JTextField) ;

        contents.add(new JLabel("Number 3")) ;
        contents.add(number3JTextField) ;

        JButton computeJButton = new JButton("Compute") ;
        contents.add(computeJButton) ;
        computeJButton.addActionListener(this) ;

        contents.add(new JLabel("GCD of Number 1, number 2 and number 3")) ;
        contents.add(resultJTextField) ;
        resultJTextField.setEnabled(false) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        pack() ;

      }//GCD

      //Act upon button being pressed

    public void actionPerformed(ActionEvent event)
      {
        int number1 = Integer.parseInt(number1JTextField.getText()) ;
        int number2 = Integer.parseInt(number2JTextField.getText()) ;
        int number3 = Integer.parseInt(number3JTextField.getText()) ;
        int theGCD = MyMath.greatestCommonDivisor(number1, number2) ;
        theGCD = MyMath.greatestCommonDivisor(theGCD, number3) ;
        resultJTextField.setText("" + theGCD) ;
      }//action performed

    public static void main(String[] args)
      {
        GCD theGCDObject = new GCD() ;
        theGCDObject.setVisible(true) ;
        theGCDObject.resultJTextField.setEnabled(false) ;
      }//main

      //calculating the greatestCommonDivisor for 2 numbers

      }//class GCD
