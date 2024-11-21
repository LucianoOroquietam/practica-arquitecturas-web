package Controller;

import Service.CompraService;

import java.util.Date;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping("/{id_cliente}")
    public ResponseEntity<?> getHistorialCompra(@PathVariable Long id_cliente, @RequestParam Date fecha_inicio, @RequestParam Date fecha_fin){
        try {
            if (id_cliente!=null && fecha_inicio!=null && fecha_fin!=null){
                return ResponseEntity.status(HttpStatus.OK).body(compraService.getHistorialCompra(id_cliente,fecha_inicio,fecha_fin));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el " + id_cliente + " o la fecha ingresada " + fecha_inicio + " " + fecha_fin + "" +
                        "son incorrectos");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
