import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.JButton ;
import javax.swing.JFrame ;
import javax.swing.JLabel ;

//creating the class StopClock

//A simple stop/split clock program. The button stops or starts the clock.
//It can also split the time
public class StopClock extends JFrame implements ActionListener
  {
    //true if and only the clock is running
    private boolean isRunning = false ;

    //The time when the clock is started/is stopped

    private long startTime = 0 ;
    private long stopTime = 0 ;

    //The time when the time is splitted

    private long splitTime = 0 ;

    //a label for showing the start/stop/split/elapsed time

    private final JLabel startTimeJLabel = new JLabel("Not started") ;
    private final JLabel stopTimeJLabel = new JLabel("Not started") ;
    private final JLabel splitTimeJLabel = new JLabel("Not started") ;
    private final JLabel elapsedTimeJLabel = new JLabel("Not started") ;

    //creating instance variables
    private JButton startStopJButton ;
    private JButton splitTimeJButton ;

    //constructor

    public StopClock()
      {
        setTitle("Stop Clock") ;

        Container contents = getContentPane() ;
        contents.setLayout(new GridLayout(0, 1)) ;

        contents.add(new JLabel("Started at:")) ;
        contents.add(startTimeJLabel) ;

        contents.add(new JLabel("Stopped at:")) ;
        contents.add(stopTimeJLabel) ;

        contents.add(new JLabel("Splitted at:")) ;
        contents.add(splitTimeJLabel) ;

        contents.add(new JLabel("Elapsed time(seconds)")) ;
        contents.add(elapsedTimeJLabel) ;

        startStopJButton = new JButton("Start/Stop") ;
        startStopJButton.addActionListener(this) ;
        contents.add(startStopJButton) ;

        splitTimeJButton = new JButton("Split") ;
        splitTimeJButton.addActionListener(this) ;
        contents.add(splitTimeJButton) ;


        setDefaultCloseOperation(EXIT_ON_CLOSE) ;
        pack() ;
      }//StopClock
    //testing when to split or start/stop
    public void actionPerformed(ActionEvent event)
      {
        if(!isRunning && event.getSource() == startStopJButton)
          {
            //Start the Clock
            startTime = System.currentTimeMillis() ;
            startTimeJLabel.setText("" + startTime) ;
            stopTimeJLabel.setText("Running...") ;
            splitTimeJLabel.setText("Running...") ;
            elapsedTimeJLabel.setText("Running...") ;
            startStopJButton.setText("Start/Stop") ;
            isRunning = true ;
          }//if
        else
          if(!isRunning && event.getSource() == splitTimeJButton)
            {
              startTimeJLabel.setText("Not started") ;
              stopTimeJLabel.setText("Not started") ;
              splitTimeJLabel.setText("Not started") ;
              elapsedTimeJLabel.setText("Not started") ;
              startStopJButton.setText("Start/Stop") ;
            }
          else
          if(isRunning && event.getSource() == startStopJButton)
            {
              stopTime = System.currentTimeMillis() ;
              stopTimeJLabel.setText("" + stopTime) ;
              long elapsedMiliSeconds = stopTime - startTime ;
              elapsedTimeJLabel.setText("" + elapsedMiliSeconds / 1000.0) ;
              startStopJButton.setText("Start/Stop") ;
              isRunning = false ;
            }//if
          else
            if(isRunning && event.getSource() == splitTimeJButton)
              {
                splitTime = System.currentTimeMillis() ;
                splitTimeJLabel.setText("" + (splitTime - startTime) / 1000.0) ;
              }//if

        pack() ;
      }//actionPerformed
    public static void main(String[] args)
      {
        StopClock theStopClock = new StopClock() ;
        theStopClock.setVisible(true) ;
      }//main
  }
