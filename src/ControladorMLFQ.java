
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Banegas Jandry
 */
public class ControladorMLFQ {

    public int duracionTotal(ArrayList<Proceso> procesos) {
        int tTo = 0;
        tTo = procesos.stream().map((p) -> p.getDurProceso()).reduce(tTo, Integer::sum);
        return tTo;
    }

    public double promedioDeDuracionTodos(ArrayList<Proceso> todos) {
        return duracionTotal(todos) / todos.size();
    }

    public ArrayList<Proceso> ordenarProcesosPorDuracion(ArrayList<Proceso> todos) {
        for (int i = 0; i < todos.size() - 1; i++) {
            for (int j = i + 1; j < todos.size(); j++) {
                if (todos.get(j).getDurProceso() <= todos.get(i).getDurProceso()) {
                    Proceso aux = todos.get(i);
                    todos.set(i, todos.get(j));
                    todos.set(j, aux);
                }
            }
        }
        return todos;
    }

    public void agregarAOtraLista(ArrayList<Proceso> todos, ArrayList<Proceso> lista) {
        lista.stream().forEach((p) -> {
            todos.add(p);
        });
    }

    public boolean procesoExiste(Proceso p, ArrayList<Proceso> procesos) {
        for (Proceso cadaPro : procesos) {
            if (cadaPro.getNomProceso().equals(p.getNomProceso())) {
                System.out.println(cadaPro.getNomProceso());
                return true;
            }
        }
        return false;
    }

    public String[][] convertirAMatrizParaTabla(ArrayList<Proceso> proc) {
        String procesos[][] = new String[proc.size()][3];
        for (int i = 0; i < proc.size(); i++) {
            procesos[i][0] = proc.get(i).getNomProceso();
            procesos[i][1] = proc.get(i).getDurProceso() + " milisegundos";
            if (proc.get(i).getNumCola() == 0) {
                procesos[i][2] = "Proceso de usuario";
            } else if (proc.get(i).getNumCola() == 1) {
                procesos[i][2] = "Proceso de sistema";
            } else {
                procesos[i][2] = "Proceso de aplicación";
            }
        }
        return procesos;
    }

    public void ubicarEnDiagramaDeGantt(JPanel jpanelGantt, ArrayList<Proceso> procesosTodos) {
        jpanelGantt.removeAll();
        jpanelGantt.setLayout(new GridLayout(1, procesosTodos.size(), 5, 5));
        for (Proceso p : procesosTodos) {
            JLabel jlCadaCuadro = new JLabel("<" + p.getNomProceso() + "><Duración: " + p.getDurProceso() + " milisegundos>");
            jlCadaCuadro.setBorder(new LineBorder(Color.BLACK, 2, true));
            if (p.getNumCola() == 0) {
                jlCadaCuadro.setBackground(Color.yellow);
            } else if (p.getNumCola() == 1) {
                jlCadaCuadro.setBackground(Color.cyan);
            } else {
                jlCadaCuadro.setBackground(Color.green);
            }
            jlCadaCuadro.setOpaque(true);
            jpanelGantt.add(jlCadaCuadro);
        }
    }

}
