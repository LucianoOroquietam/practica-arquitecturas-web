@RestController
@RequestMapping("api/empleados")
public EmpleadosController{
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/jefes/{id}")
    public ResponseEntity<?> getCadenaJefes(@PathVariable("id") Long id){
        try{
            if (id != null){
                return ResponseEntity.status(HttpStatus.OK).body(empleadoService.getCadenaJefes(id));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("empleado con id: "+ id+ " no encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
