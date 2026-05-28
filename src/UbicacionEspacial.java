import java.util.Objects;

public class UbicacionEspacial {

    private double latitud;
    private String hemisferionortesur;
    private double longitud;
    private String hemisferioesteoeste;
    private String periodo;

    public UbicacionEspacial(double latitud, String hemisferionortesur,
                             double longitud, String hemisferioesteoeste,
                             String periodo) throws GradosException, PeriodoInv{
        if (Math.abs(latitud) > 180) {
            throw new GradosException("Error: La latitud (" + latitud + ") no puede superar los 180 grados.");
        }
        if (Math.abs(longitud) > 180) {
            throw new GradosException("Error: La longitud (" + longitud + ") no puede superar los 180 grados.");
        }
        if (!esMesValido(periodo)) {
            throw new PeriodoInv("Error: '" + periodo + "' no es un mes válido del año.");
        }

        this.latitud = latitud;
        this.hemisferionortesur = hemisferionortesur;
        this.longitud = longitud;
        this.hemisferioesteoeste = hemisferioesteoeste;
        this.periodo = periodo;
    }
    private boolean esMesValido(String mes) {
        if (mes == null) return false;

        String[] mesesValidos = {
                "enero", "febrero", "marzo", "abril", "mayo", "junio",
                "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
        };

        String mesLimpio = mes.trim().toLowerCase();
        for (String m : mesesValidos) {
            if (m.equals(mesLimpio)) {
                return true;
            }
        }
        return false;
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