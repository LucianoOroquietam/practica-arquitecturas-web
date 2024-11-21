
@FeignClient(name = "api-tareas", url="https://api-tareas.com:8080")
public interface ApiExternaClient {

    @GetMapping("/tarea/horas/{id_empledo}")
    List<HorasDTO> getHoras(
            @PathVariable Long empleadoId,
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    );
}