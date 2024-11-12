//lombok
@Data
public class ReportDto {
    private int idCliente;
    private String nombre;

    private int cantTransacciones;
    private float promedio;

    private int idProducto;
    private String nombreProducto;
    private int cantUnidades;
}
