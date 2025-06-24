
package batallafinal;

import java.util.Random;


public class Personaje {
    Random random = new Random ();
    private String nombre;
    private int vida;
    private int ataquemin;
    private int ataquemax;
    private int evasion;
    private boolean regeneracion;

    public Personaje(String nombre, int vida, int ataquemin, int ataquemax, int evasion, boolean regeneracion) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataquemin = ataquemin;
        this.ataquemax = ataquemax;
        this.evasion = evasion;
        this.regeneracion = regeneracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaquemin() {
        return ataquemin;
    }

    public void setAtaquemin(int ataquemin) {
        this.ataquemin = ataquemin;
    }

    public int getAtaquemax() {
        return ataquemax;
    }

    public void setAtaquemax(int ataquemax) {
        this.ataquemax = ataquemax;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public boolean isRegeneracion() {
        return regeneracion;
    }

    public void setRegeneracion(boolean regeneracion) {
        this.regeneracion = regeneracion;
    }
      public int atacar() {
        return new Random().nextInt(ataquemax - ataquemin + 1) + ataquemin;
    }
      public boolean evade() {
        return new Random().nextInt(100) < evasion;
    }
         public boolean estaVivo() {
        return vida > 0;
    }
}
