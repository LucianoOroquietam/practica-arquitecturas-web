

@Repository
public interface RepositoryEmpleado extends JpaRepository<empleado, long>{

    @Query (new ReportDTOHoras("" +
            "" +
            "" +
            "" +
            "" +
            "" +
            ""))
    ReportDTOHoras getHoras(int id, Date fecha_inicio, Date fecha_fin);

}
