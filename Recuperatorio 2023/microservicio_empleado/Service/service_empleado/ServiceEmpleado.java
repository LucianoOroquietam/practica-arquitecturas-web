import java.util.ArrayList;

@Service
public class ServiceEmpleado {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    public ReportDTOHoras getHoras(int id, Date fecha_inicio, Date fecha_fin){
        return repositoryEmpleado.getHoras(id,fecha_inicio,fecha_fin);
    }

    /*si lo dejo solo asi tendria un jefe solo no la cadena completa, al ser autoreferencial debo llamar recursivamente
    segun gpt
    public List<CadenaJefeDTO> getCadenaJefes(int id_jefe){
        return repositoryEmpleado.getCadenaJefes(id_jefe);
    }*/


    public List<CadenaJefeDTO> getCadenaJefes(int id_jefe){
        //hacemos una lista para guardar la cadena de jefes que nos piden
       List<CadenaJefeDTO> cadenaJefeDTO = new ArrayList<>();
       //instanciamos empleado y obtenemos el id del jefe del mismo (getrefencedbyid lo busque, es del jparepository)
       Empleado empleado = repositoryEmpleado.getReferencedById(id_jefe);


        //mientras un empleado tenga un jefe se llame al while
       while (empleado.getJefe() != null){
           //hacemos como una copia del dto con los getters y setters
           CadenaJefeDTO dto = new CadenaJefeDTO(empleado.getJefe().getId(), empleado.getId(), empleado.getNombre());
           cadenaJefeDTO.add(dto);
           //aca llamo recursivamente
           empleado = empleado.getJefe();
       }

       return cadenaJefeDTO;

    }
}