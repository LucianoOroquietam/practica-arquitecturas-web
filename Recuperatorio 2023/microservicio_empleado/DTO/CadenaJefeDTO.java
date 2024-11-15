
@Data
public class CadenaJefeDTO {

    private int id_jefe;
    private int id_empleado;
    private String nombre_empleado;

    public CadenaJefeDTO(int id_jefe, int id_empleado, String nombre_empleado){
        this.id_jefe = id_jefe;
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
    }

}
