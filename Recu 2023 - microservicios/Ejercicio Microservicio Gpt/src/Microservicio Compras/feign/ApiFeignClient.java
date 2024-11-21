package feign;
@FeignClient(name= "api-compra", url="http://api-compra.com:8082", fallback = ApiFeignClientFallback.class)
public interface ApiFeignClient {

    @GetMapping("/compras/{id_cliente}")
    List<Compra>getHistorialCompra(@PathVariable Long id_cliente,@RequestParam Date fechaInicio,@RequestParam Date fechaFin);
}

//de goloso
@Component
public class ApiFeignClientFallback implements ApiFeignClient {

    @Override
    public List<Compra> getHistorialCompra(Long id_cliente, String fechaInicio, String fechaFin) {
        // Retornamos una lista vacía o algún mensaje por defecto
        return new ArrayList<>();
    }
}