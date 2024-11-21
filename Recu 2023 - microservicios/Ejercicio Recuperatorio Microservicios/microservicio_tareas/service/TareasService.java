
@Service
public class TareasService {
    @Autowired
    private TareasRepository tareasRepository;

    public List<HorasDTO> getHorasTrabajadas(Long id,LocalDate fechaInicio,LocalDate fechaFin){
        List<HorasDTO> horasDTO = this.tareasRepository.getHoras(id, fechaInicio, fechaFin);
        return horasDTO;
    }



}