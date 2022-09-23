
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class COMIDA extends JPanel {
    Random rnd = new Random();
    int w;
    int h;
    public COMIDA(int w,int h) {
        this.w = w;
        this.h = h;
        int x = rnd.nextInt(10);
        int y = rnd.nextInt(10);
        this.setBounds(x * (w - 1),y * (h - 1),w,h);
        this.setBackground(new Color(255,200,0));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    public void reubicar() { 
        int x = rnd.nextInt(10);
        int y = rnd.nextInt(10);
        this.setLocation(x * (w - 1),y * (h - 1));
    }
}
