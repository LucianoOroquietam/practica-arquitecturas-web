

@Service
public class ServiceEmpleado {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    public ReportDTOHoras getHoras(int id, Date fecha_inicio, Date fecha_fin){
        return repositoryEmpleado.getHoras(id,fecha_inicio,fecha_fin);
    }
}