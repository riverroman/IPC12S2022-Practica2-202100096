
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class COLORSNAKE extends JPanel {
    private int xf;
    private int yf;
    
    public COLORSNAKE(int w,int h) {
        this.setBounds(-45,-45,w,h);
        this.setBackground(new Color(0,255,255));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    public COLORSNAKE(int x,int y,int w,int h) {
        this.setBounds(x,y,w,h);
        this.setBackground(new Color(0,255,255));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    public void setXf(int xf) {
        this.xf = xf;
    }
    
    public int getXf() {
        return xf;
    }
    
    public void setYf(int yf) {
        this.yf = yf;
    }
    
    public int getYf() {
        return yf;
    }
}

