/*
   BUSCAR EN UNA DB SQL
* informacion de los usuarios (clientes) cuya edad es menor a un valor dado, y que hayan realizado
* al menos 3 transacciones de compra de productros del rubro golosina en un mismo dia.

* Se debe proveer el identificador y nombre de cada usuario (seleccionado) , la cantidad total
* de transacciones realizadas y el valor del ticket promedio de dichas transacciones. Se debe
* proveer identificador y descripcion de cada producto (seleccionado) y la cantidad total de
* unidades vendidas.

* Ademas del pseudo-codigo comente las clases e interfaces java que se deben
* implementar y como estas se relacionan a la hora de resolver el servicio.
*
* Entidades:
* Cliente. (int id, string nombre , string apellido, int edad)
* Transaccion. (int id, float total, int fk_cliente)
* Transaccion_Productos (int fk_transaccion, int fk_producto)
* Productos. (int id, string descripcion, int valor, string rubro)
*

*
* */
@RestController
@GetMapping("/clients")
public class Controller {
    @Autowired
    private ServiceClient s;

    @GetMapping("")
    public ResponseEntity<?> getTransacciones(@RequestParam("edad") int edad){
        try{
            if(edad >= 18) {
                return ResponseEntity.status(HTTPstatus.OK).body(this.s.getClientsPorEdad(edad));
            }else {
                return ResponseEntity.status(HTTPstatus.BAD_REQUEST).body("Debe ser mayor de edad para hacer transacciones");
            }
        }catch (Exception e){
            e.getMessage();
        }

    }

}