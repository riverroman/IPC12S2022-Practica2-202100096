import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AVANZAR extends Thread {
    private boolean arriba = false,abajo = false,izquierda = false,derecha = false;
    private int intervalo = 1000, tamano = 1;
    private double fraccion = 1;
    COMIDA fruta;
    JPanel casillas;
    COLORSNAKE[] serpiente;
    JLabel tamanoSerpiente;
    JLabel velocidadSerpiente;
    INTERFAZ ventana;
    
    public AVANZAR(COMIDA fruta,JPanel casillas,COLORSNAKE[] serpiente,String dificultad,JLabel tamanoSerpiente,JLabel velocidadSerpiente,INTERFAZ ventana) {
        this.fruta = fruta;
        this.casillas = casillas;
        this.serpiente = serpiente;
        this.tamanoSerpiente = tamanoSerpiente;
        this.velocidadSerpiente = velocidadSerpiente;
        this.ventana = ventana;
        
        if(dificultad.equals("FACIL")) {
            fraccion = fraccion - 0.03;
        }else if(dificultad.equals("MEDIO")) {
            fraccion = fraccion - 0.06;
        }else if(dificultad.equals("DIFICIL")) {
            fraccion = fraccion - 0.09;
        }
    }
    
    public void run() {
        try {
            while(sinChocar()) {
                if(arriba == true) {
                    serpiente[0].setXf(serpiente[0].getX());
                    serpiente[0].setYf(serpiente[0].getY() - 39);
                    
                    moverSerpiente();
                }
                else if(abajo == true) {
                    serpiente[0].setXf(serpiente[0].getX());
                    serpiente[0].setYf(serpiente[0].getY() + 39);
                    
                    moverSerpiente();
                }
              
                else if(izquierda == true) {
                 
                    serpiente[0].setXf(serpiente[0].getX() - 39);
                    serpiente[0].setYf(serpiente[0].getY());
                    
                    moverSerpiente();
                }
          
                else if(derecha == true) {
          
                    serpiente[0].setXf(serpiente[0].getX() + 39);
                    serpiente[0].setYf(serpiente[0].getY());
                    
                    moverSerpiente();
                }
               
                if(serpiente[0].getX() == fruta.getX() && serpiente[0].getY() == fruta.getY()) {
                    serpiente[tamano] = new COLORSNAKE(40,40);
                    casillas.add(serpiente[tamano]);  
                    fruta.reubicar();
                    tamano = tamano + 1;
                    intervalo = (int) (intervalo * fraccion);
                 
                    tamanoSerpiente.setText(String.valueOf(tamano));
                    velocidadSerpiente.setText(String.valueOf(intervalo));
                }
                
                if(tamano == 25) {
                    JOptionPane.showMessageDialog(ventana," LA SERPIENTE HA LLEGADO AL LIMITE DE COMIDA");
                    tamanoSerpiente.setText("1");
                    velocidadSerpiente.setText("1000");
                    casillas.removeAll();
                    ventana.revalidate();
                    ventana.repaint();
                   
                    ventana.juego = null;
                    return;
                }
                else if(haChocado()) {
                    break;
                }
                
                sleep(intervalo);
            }
            
            JOptionPane.showMessageDialog(ventana,"HAS PERDIDO, LA SERPIENTE CHOCO EN EL MURO");
            tamanoSerpiente.setText("1");
            velocidadSerpiente.setText("1000");
            casillas.removeAll();
            ventana.revalidate();
            ventana.repaint();
            ventana.juego = null;
            
        } catch (InterruptedException ex) {
            Logger.getLogger(AVANZAR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void moverArriba() {
        arriba = true;
        abajo = false;
        izquierda = false;
        derecha = false;
    }
    
    public void moverAbajo() {
        arriba = false;
        abajo = true;
        izquierda = false;
        derecha = false;
    }
    
    public void moverIzquierda() {
        arriba = false;
        abajo = false;
        izquierda = true;
        derecha = false;
    }
    
    public void moverDerecha() {
        arriba = false;
        abajo = false;
        izquierda = false;
        derecha = true;
    }
    
    private boolean sinChocar() {
        if(serpiente[0].getX() >= 0 &&
                serpiente[0].getX() <= 352 &&
                serpiente[0].getY() >= 0 &&
                serpiente[0].getY() <= 352) {
            return true;
        }
        return false;
    }
    
    private boolean haChocado() {
        if(serpiente[0].getX() < 0 ||
                serpiente[0].getX() > 352 ||
                serpiente[0].getY() < 0 ||
                serpiente[0].getY() > 352) {
            return true;
        }
        return false;
    }
    
    private void moverSerpiente() {
        for(int i = 0; i < serpiente.length; i ++) {
            
            if(serpiente[i] == null) {
                break;
            }

            if(i + 1 < serpiente.length && serpiente[i + 1] != null) {
                
                serpiente[i + 1].setXf(serpiente[i].getX());
                serpiente[i + 1].setYf(serpiente[i].getY());
            }
            serpiente[i].setLocation(serpiente[i].getXf(),serpiente[i].getYf());
        }
    }
}
