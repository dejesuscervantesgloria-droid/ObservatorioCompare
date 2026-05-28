import java.util.ArrayList;
import java.util.Collections;

public class GestionObservatorio {


    private ArrayList<CuerpoCeleste> listaCuerpos;

    public GestionObservatorio() {
        this.listaCuerpos = new ArrayList<>();
    }


    public void registrarCuerpoCeleste(String nombre, String composicion, double distancia,
                                       double latitud, String hemisferioNS,
                                       double longitud, String hemisferioEO, String periodo)throws GradosException, PeriodoInv {
        try {
            UbicacionEspacial ubicacion = new UbicacionEspacial(latitud, hemisferioNS, longitud, hemisferioEO, periodo);

            CuerpoCeleste nuevoCuerpo = new CuerpoCeleste(nombre, composicion, distancia, ubicacion);

            listaCuerpos.add(nuevoCuerpo);
            System.out.println("-> [ÉXITO] '" + nombre + "' ha sido registrado en el catálogo.");

        } catch (GradosException  | PeriodoInv e) {
            System.err.println("-> [ERROR DE VALIDACIÓN] No se pudo registrar '" + nombre + "'. Motivo: " + e.getMessage());
        }
    }

    public void mostrarCatalogo() {
        System.out.println("\n--- CATÁLOGO DE CUERPOS CELESTES ---");
        if (listaCuerpos.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }
        for (CuerpoCeleste cc : listaCuerpos) {
            System.out.println("- " + cc.getNombre() + " (Distancia: " + cc.getDistanciaTierra() + " años luz/km)");
        }
    }

    public void ordenarPorNombre() {
        Collections.sort(listaCuerpos);
        System.out.println("\n[INFO] Catálogo ordenado alfabéticamente por nombre.");
    }

    public void ordenarPorDistancia() {
        Collections.sort(listaCuerpos, CuerpoCeleste.DistanciaComparator);
        System.out.println("\n[INFO] Catálogo ordenado por distancia a la Tierra.");
    }
}