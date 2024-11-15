
@Entity
@Data
public class Empleado{
    @Id
    @GeneratedValue(strategy = generationType.IDENTITY)
    private int id;

    @Column
    private String nombre;
    @Column
    private String apellido;

    //muchos empleados pueden tener el mismo jefe
    @ManyToOne
    @JoinColumn(name = "id_jefe")
    private Empleado jefe;
}