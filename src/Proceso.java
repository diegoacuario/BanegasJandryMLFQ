
/**
 *
 * @author Ing Diego Romero Armijos
 */
public final class Proceso {

    private String nomProceso;
    private int durProceso;
    private int numCola;

    public Proceso(String nomProceso, int durProceso, int numCola) {
        this.nomProceso = nomProceso;
        this.durProceso = durProceso;
        this.numCola = numCola;
    }

    public String getNomProceso() {
        return nomProceso;
    }

    public void setNomProceso(String nomProceso) {
        this.nomProceso = nomProceso;
    }

    public int getDurProceso() {
        return durProceso;
    }

    public void setDurProceso(int durProceso) {
        this.durProceso = durProceso;
    }

    public int getNumCola() {
        return numCola;
    }

    public void setNumCola(int numCola) {
        this.numCola = numCola;
    }

}
