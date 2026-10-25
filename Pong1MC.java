package pong1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Pong1MC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//invokeLater suggested by Claude. Didn't quite understand why.
		SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My First Java Window");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            Paddle playerPaddle = new Paddle();

            
        	JPanel background = new JPanel() {
        		
        		@Override
        	    protected void paintComponent(Graphics g) {
        	        super.paintComponent(g);
        	        Graphics2D g2 = (Graphics2D) g;
        	        g2.setColor(Color.BLUE);
        	        g2.fillRect(0, 0, 1200, 800);
        	       
        	        
        	        playerPaddle.draw(g2);
        	    }
        	};
        	
        	background.addMouseWheelListener(new MouseWheelListener() {
        		  @Override
        		    public void mouseWheelMoved(MouseWheelEvent e) {
        		        int rotation = e.getWheelRotation(); // negative = up/away, positive = down/toward you
        		        System.out.println("Wheel moved: " + rotation);
        		        playerPaddle.changePaddleLocation(rotation);
        		        background.repaint();
        		    }
        	});


            frame.setLayout(new BorderLayout(10, 10));
            //frame.add(label, BorderLayout.CENTER);
            //frame.add(button, BorderLayout.SOUTH);

            frame.add(background);
            frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
	}

}
	
	class Paddle {
		int yCenter = 400;		
		int topValue = yCenter - 50;
		int bottomValue = yCenter + 50 ;
		
		
		public void changePaddleLocation(int input) {		
			//Get Last Frame location
			//Move up or down based on mousewheel, (may require additional function)
				//yCenter +- x;
			yCenter = yCenter + (input * 25);
			topValue = yCenter - 50;
			bottomValue = yCenter + 50;
			//set Frame Position
			
			//(Repaint)
		}
		
		public void draw(Graphics2D g2) {
			g2.setColor(Color.WHITE);
			g2.fillRect(100, topValue, 50, 200);
		}
		
	}
	

	

