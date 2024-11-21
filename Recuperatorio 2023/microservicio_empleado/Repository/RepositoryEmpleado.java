
/*
* Un servicio que consulte la cantidad de horas trabajadas por una persona (empleado) en
    distintas tareas que tengan asignadas. para un periodo de tiempo dado.
    *
    * Empleado(int id, string nombre, string apellido,int id_jefe)
      Tareas(int id, string nombre, time horas_trabajadas, date fecha, int fk_empleado)
* */
@Repository
public interface RepositoryEmpleado extends JpaRepository<empleado, Long>{

    @Query("SELECT new com.example.demo.ReportDTOHoras(t.id, t.nombre, SUM(t.horas_trabajadas), e.nombre) " +
            "FROM Empleado e " +
            "JOIN Tareas t ON t.fk_empleado = e.id " +
            "WHERE e.id = :id AND t.fecha BETWEEN :fecha_inicio AND :fecha_fin " +
            "GROUP BY t.id, t.nombre, e.nombre")
    ReportDTOHoras getHoras(@Param("id") int id,
                            @Param("fecha_inicio") Date fecha_inicio,
                            @Param("fecha_fin") Date fecha_fin);


    /*
    *   Un servicio que retorna la cadena de jefes de un empleado. Para esto, considerar que cada empleado
        reporta a un jefe directo , y a su vez a cada jefe puede reportar a otro jefe(superior) y asi
        sucesivamente.
    * */

    @Query("SELECT new com.example.demo.CadenaJefeDto(e.id, e.nombre, e.id_jefe " +
            "FROM Empleado e" +
            "WHERE e.id_jefe = :id_jefe")
    CadenaJefeDTO getCadenaJefes(@Param ("id") int id_jefe);
}
