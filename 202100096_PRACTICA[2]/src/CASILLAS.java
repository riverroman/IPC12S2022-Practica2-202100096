
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CASILLAS extends JPanel {
    public CASILLAS(int x,int y,int w,int h) {
	this.setBounds(x,y,w,h);
	this.setBackground(Color.gray);
	this.setBorder(BorderFactory.createLineBorder(Color.black));
   }
}
