/**
 * Tareas(int id, string nombre, time horas_trabajadas, date fecha, int fk_empleado)
 */

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerateType.IDENTITY)
    private int id;

    @Colum
    private String nombre;

    @Colum
    private Time horas_trabajadas;

    @Colum
    private Date fecha;

    @ManyToOne
    @JoinColum(name = "fk_empleado")
    private Empleado empleado;



}