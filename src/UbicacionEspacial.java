import java.util.Objects;

public class UbicacionEspacial {

    private double latitud;
    private String hemisferionortesur;
    private double longitud;
    private String hemisferioesteoeste;
    private String periodo;

    public UbicacionEspacial(double latitud, String hemisferionortesur,
                             double longitud, String hemisferioesteoeste,
                             String periodo) {
        this.latitud = latitud;
        this.hemisferionortesur = hemisferionortesur;
        this.longitud = longitud;
        this.hemisferioesteoeste = hemisferioesteoeste;
        this.periodo = periodo;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UbicacionEspacial that = (UbicacionEspacial) o;
        return Double.compare(that.latitud, latitud) == 0 &&
                Double.compare(that.longitud, longitud) == 0 &&
                Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud, periodo);
    }
}