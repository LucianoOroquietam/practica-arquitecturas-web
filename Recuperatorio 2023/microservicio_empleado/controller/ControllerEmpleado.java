

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
    */

    @GetMapping("/horas/{id}")
    public ResponseEntity<?> getHoras(@PathVariable("id") int id, @RequestParam("fecha_inicio") Date fecha_inicio , @RequestParam("fecha_fin") Date fecha_fin){
        try{
            if (id > 0 && fecha_inicio != null && fecha_fin != null){
                return ResponseEntity.status(HttpStatus.OK).body(serviceEmpleado.getHoras(id,fecha_inicio,fecha_fin));
            } else {
                return ResponseEntity.status(HTTPstatus.BAD_REQUEST).body("Le erraste pa");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}