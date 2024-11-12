
@Service
public class ServiceClient {

    @Autowired
    private RepositoryClient r;

    public List<ReportDTO> getClientsPorEdad(int edad){
        return this.r.getClientsPorEdad(edad);
    }
}