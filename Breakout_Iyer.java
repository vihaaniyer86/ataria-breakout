// @author Vihaan Iyer

/**
   Sources:
   https://stackoverflow.com/questions/7799940/jframe-exit-on-close-java

**/


/**
   Import Statements
**/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
   Large class containing code to create the elements of the game
**/
public class Breakout_Iyer extends JPanel {
   /**
      Variables for the dimensions of the frame and bricks
   **/
   private static final int CANVAS_WIDTH = 600;
   private static final int CANVAS_HEIGHT = 700;
   private static final int NUM_BRICK_COLUMNS = 10;
   private static final int NUM_BRICK_ROWS = 10;
   private static final int BRICK_SEP_SIZE = 4;
   private static final int BRICK_WIDTH = (CANVAS_WIDTH - BRICK_SEP_SIZE * (NUM_BRICK_COLUMNS + 1)) / NUM_BRICK_COLUMNS;
   private static final int BRICK_HEIGHT = 10;
   private static final int BRICK_Y_OFFSET = 70;
   private static final int TOTAL_BRICK_WIDTH = (BRICK_SEP_SIZE + BRICK_WIDTH) * (NUM_BRICK_COLUMNS - 1) + BRICK_WIDTH;
   private static final int BRICK_X_OFFSET = (CANVAS_WIDTH - TOTAL_BRICK_WIDTH) / 2;
 
   private static final Color[] COLORS = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE};
   
   
   /**
      Overrides method to create bricks of several different colors 
      At the end, method creates a ball and the paddle for the game
   **/
   @Override
   protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      Graphics2D g2d = (Graphics2D) graphics;
  
      int x = BRICK_X_OFFSET;
      int y = BRICK_Y_OFFSET;
  
      for (int row = 0; row < NUM_BRICK_ROWS; row++) {
         for (int col = 0; col < NUM_BRICK_COLUMNS; col++) {
            Rectangle brick = new Rectangle(x, y, BRICK_WIDTH, BRICK_HEIGHT);
            g2d.setColor(COLORS[col % COLORS.length]);
            g2d.fill(brick);
            g2d.setColor(Color.BLACK);
            g2d.draw(brick);
            x += BRICK_WIDTH + BRICK_SEP_SIZE;
         }
         x = BRICK_X_OFFSET;
         y += BRICK_HEIGHT + BRICK_SEP_SIZE;
      }
      createBall(g2d);
      createPaddle(g2d);
   }
   
   /**
      Constants needed to create a ball and paddle
   **/
   private static final int BALL_RADIUS = 10;
   private static final int PADDLE_WIDTH = 70;
   private static final int PADDLE_HEIGHT = 15;
   private static final int PADDLE_Y_OFFSET = 50;
   
   
   /**
      Method to create a ball in the frame
   **/
   public void createBall(Graphics2D g) {
      g.setColor(Color.GRAY);
      g.fillOval(CANVAS_WIDTH / 2 - (BALL_RADIUS / 2), CANVAS_HEIGHT - (PADDLE_Y_OFFSET * 3), BALL_RADIUS
         , BALL_RADIUS);
      
   }
   
   /**
      Method to create a paddle in the frame
   **/
   public void createPaddle(Graphics2D g) {
      g.setColor(Color.BLUE);
      g.fillRect((CANVAS_WIDTH / 2) - (PADDLE_WIDTH / 2), CANVAS_HEIGHT - PADDLE_Y_OFFSET * 2,
         PADDLE_WIDTH, PADDLE_HEIGHT);

   }
   
   
   /**
      Constructor that creates the frame for game
      @author Jaime Hablutzel
   **/
   public Breakout_Iyer() {
      JFrame frame = new JFrame("Ataria Breakout");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
      frame.setResizable(false);
      frame.add(this);
      frame.setVisible(true);
   }
 
   
   /**
      Main method which calls constructor to create a window and run the game
   **/
   public static void main(String[] args) {
        new Breakout_Iyer();
   }
}



