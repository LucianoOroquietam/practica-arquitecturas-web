@Service
public class EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getCadenaJefes(Long id) {

        Empleado empleadoActual=empleadoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("empleado no existe"));
        List<Empleado> jefes = new ArrayList();

        while(empleadoActual.getJefe()!=null){
            Empleado jefe=empleadoActual.getJefe();
            jefes.add(jefe);
            empleadoActual=jefe;
        }
        return jefes;
    }


/*

    Otra solucion

    // Servicio
    public List<String> obtenerCadenaDeJefes(Long empleadoId) {
        List<String> jefes = new ArrayList<>();
        Long jefeActual = empleadoRepository.obtenerJefeDirecto(empleadoId);
        while (jefeActual != null) {
            jefes.add(empleadoRepository.obtenerNombrePorId(jefeActual));
            jefeActual = empleadoRepository.obtenerJefeDirecto(jefeActual);
        }
        return jefes;
    }

    // Repositorio
    @Query("SELECT e.jefeId FROM Empleado e WHERE e.id = :empleadoId")
    Long obtenerJefeDirecto(@Param("empleadoId") Long empleadoId);

    @Query("SELECT e.nombre FROM Empleado e WHERE e.id = :id")
    String obtenerNombrePorId(@Param("id") Long id);


*/

}





