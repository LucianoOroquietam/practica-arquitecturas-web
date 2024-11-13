@Repository
public interface RepositoryClient implements JpaRepostory<ReportDTO, Long>{

    @Query("SELECT new com.example.ReportDTO(c.id, c.nombre, COUNT(t.id) AS cantTransacciones, " +
        "AVG(t.total) AS promedio, " +
        "p.id, p.nombre, C0UNT(p.id) AS totalUnidades)"
        "FROM cliente c" +
        "JOIN transaccion t ON c.id = t.fk_cliente" +
        "JOIN transaccion_productos tp ON t.id = tp.fk_transaccion" +
        "JOIN producto p ON tp.fk_producto = p.id" +
        "WHERE c.edad < :edad AND p.rubro = 'golosinas'"
        "GROUP BY c.id, p.id, t.fecha " +
        "HAVING COUNT(t.id) >= 3")
    List<ReportDTO> getClientsPorEdad(int edad);
}

