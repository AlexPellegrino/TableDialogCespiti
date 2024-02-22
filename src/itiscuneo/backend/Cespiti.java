package itiscuneo.backend;
import java.time.LocalDate;
import java.util.Objects;

public class Cespiti {
    private static final String SEPARATOR = ",";
    private String codice;
    private int quantita;
    private LocalDate dataAcquisto;

    public Cespiti(String codice, int quantita, LocalDate dataAcquisto) {
        this.codice = codice;
        this.quantita = quantita;
        this.dataAcquisto = dataAcquisto;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public LocalDate getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(LocalDate dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cespiti cespiti = (Cespiti) o;
        return quantita == cespiti.quantita && Objects.equals(codice, cespiti.codice) && Objects.equals(dataAcquisto, cespiti.dataAcquisto);
    }

    @Override
    public String toString() {
        return "Cespiti{" +
                "codice='" + codice + '\'' +
                ", quantita=" + quantita +
                ", dataAcquisto=" + dataAcquisto +
                '}';
    }

    public String toCSV(){
        return codice+SEPARATOR+quantita+SEPARATOR+dataAcquisto;
    }
}
