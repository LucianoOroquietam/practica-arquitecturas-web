import java.net.http.HttpClient;

@RestController
@RequestMapping("/api/empleado")
public class ControllerEmpleado {

    @Autowired
    private ServiceEmpleado serviceEmpleado;

    /*
    Un servicio que consulte la cantidad de horas trabajadas por una persona (empleado) en
    distintas tareas que tengan asignadas. para un periodo de tiempo dado. La informacion de tareas
    de los proyectos la provee un sistema externo mediante una API REST.

    /api/empleado/horas/5?fecha_inicio=x&fecha_fin=y


    Un servicio que retorna la cadena de jefes de un empleado. Para esto, considerar que cada empleado
    reporta a un jefe directo , y a su vez a cada jefe puede reportar a otro jefe(superior) y asi
    sucesivamente.


    */

    @GetMapping("/horas/{id}")
    public ResponseEntity<?> getHoras(@PathVariable("id") int id, @RequestParam("fecha_inicio") Date fecha_inicio , @RequestParam("fecha_fin") Date fecha_fin){
        try{
            if (id > 0 && fecha_inicio != null && fecha_fin != null){
                return ResponseEntity.status(HttpStatus.OK).body(serviceEmpleado.getHoras(id,fecha_inicio,fecha_fin));
            } else {
                return ResponseEntity.status(HTTPstatus.BAD_REQUEST).body("Verifique los datos ingresados");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrio un error inesperado en el server");
        }
    }

    @GetMapping("/{id_jefe}/cadena-jefes")
    public ResponseEntity<?> getCadenaJefes(@PathVariable int id_jefe){
        try {
            if (id_jefe > 0){
                return ResponseEntity.status(HttpStatus.OK).body(serviceEmpleado.getCadenaJefes(id_jefe));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ingrese un jefe valido");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ocurrio un error en el sv");
        }
    }

}