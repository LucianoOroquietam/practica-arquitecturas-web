@Data
public class HorasDTO{

    private Tarea id;
    private LocalDate fecha;
    private int horasTrabajadas;

    public HorasDTO(Tarea id, LocalDate fecha, int horasTrabajadas) {
        this.id = id;
        this.fecha = fecha;
        this.horasTrabajadas = horasTrabajadas;
    }
}