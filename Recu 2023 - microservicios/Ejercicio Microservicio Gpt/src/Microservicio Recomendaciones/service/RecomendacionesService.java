@Service
public RecomendacionesService(){
    @AutoWired
    private ApiFeignClient compraApi;
    @Autowired
    private RecomendacionesRepository recomendacionesRepository;


    public List<String> getRecomendaciones(Long id,Date fecha_inicio,Date fecha_fin){
        List<Compras> HistorialCompras=compraApi.getHistorialCompra(id,fecha_inicio,fecha_fin);
       return recomendacionesRepository.getRecomendaciones(HistorialCompras);
    }




}