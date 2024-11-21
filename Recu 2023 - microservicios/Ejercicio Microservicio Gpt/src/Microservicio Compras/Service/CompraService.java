package Service;

import API.CompraApi;

import java.util.ArrayList;

@Service
public class CompraService {
    @AutoWired
    private ApiFeignClient compraApi;

    public List<Compra>getHistorialCompra(Long id_cliente,Date fecha_inicio, Date fecha_fin){
        return compraApi.getHistorialCompra(id_cliente,fecha_inicio,fecha_fin);
    }

}
