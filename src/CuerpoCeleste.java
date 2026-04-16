import java.util.Comparator;
import java.util.Objects;

public class CuerpoCeleste implements Comparable<CuerpoCeleste> {

    private String nombre;
    private String composicion;
    private double distanciaTierra;
    private UbicacionEspacial ubicacion;

    public CuerpoCeleste(String nombre, String composicion,
                         double distanciaTierra,
                         UbicacionEspacial ubicacion) {
        this.nombre = nombre;
        this.composicion = composicion;
        this.distanciaTierra = distanciaTierra;
        this.ubicacion = ubicacion;
    }

    @Override
    public int compareTo(CuerpoCeleste otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    public static Comparator<CuerpoCeleste> DistanciaComparator = new Comparator<CuerpoCeleste>() {
        @Override
        public int compare(CuerpoCeleste c1, CuerpoCeleste c2) {
            return Double.compare(c1.distanciaTierra, c2.distanciaTierra);
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Objects.equals(nombre.toLowerCase(), that.nombre.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }

    public double calcularDesplazamiento(UbicacionEspacial nuevaUbicacion) {

        double deltaLat = nuevaUbicacion.getLatitud() - ubicacion.getLatitud();
        double deltaLon = nuevaUbicacion.getLongitud() - ubicacion.getLongitud();

        return Math.sqrt(Math.pow(deltaLat, 2) + Math.pow(deltaLon, 2));
    }

    public String getNombre() { return nombre; }
    public double getDistanciaTierra() { return distanciaTierra; }
}