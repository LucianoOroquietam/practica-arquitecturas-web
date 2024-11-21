
@RestController
@RequestMapping("/recomendaciones")
public RecomencacionesController(){

    @Autowired
    private RecomendacionesService recomendacionesService;

    @GetMapping("/{id_cliente}")
    public ResponseEntity<?> getRecomendaciones(@Pathvariable Long id_cliente,@RequestParam Date fecha_inicio,@RequestParam Date fecha_fin){
        try{
            if (id_cliente != null){
                return ResponseEntity.status(HttpStatus.OK).body(recomendacionesService.getRecomendaciones(id_cliente, fecha_inicio, fecha_fin));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 bad request");
            }
        }catch (Exception exc){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body.getMessage(exc);
        }
    }
}