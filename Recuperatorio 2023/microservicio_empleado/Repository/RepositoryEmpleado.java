
/*
* Un servicio que consulte la cantidad de horas trabajadas por una persona (empleado) en
    distintas tareas que tengan asignadas. para un periodo de tiempo dado.
* */
@Repository
public interface RepositoryEmpleado extends JpaRepository<empleado, long>{

    @Query("SELECT new com.example.demo.ReportDTOHoras(t.id, t.nombre, SUM(t.horas_trabajadas), e.nombre) " +
            "FROM Empleado e " +
            "JOIN Tareas t ON t.fk_empleado = e.id " +
            "WHERE e.id = :id AND t.fecha BETWEEN :fecha_inicio AND :fecha_fin " +
            "GROUP BY t.id, t.nombre, e.nombre")
    ReportDTOHoras getHoras(@Param("id") int id,
                            @Param("fecha_inicio") Date fecha_inicio,
                            @Param("fecha_fin") Date fecha_fin);
}
