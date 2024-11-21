
@RestController
@RequestMapping("/api/tarea")
public class TareasController {

    @Autowired
    private TareasService tareasService;


    @GetMapping("/horas/{id_empledo}")
    public ResponseEntity<?> getHorasTrabajadas(@PathVariable("id_empleado") Long id_empleado, @RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin){
        try {
            if (id_empleado !=null){
                return ResponseEntity.status(HttpStatus.OK).body(tareaService.getHorasTrabajadas(id_empleado, fechaInicio, fechaFin));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El empleado no existe");
            }
        } catch (exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ta mal rey");
        }
    }
}

// /api/tareas/horas/1?fecha=1&fin=2

