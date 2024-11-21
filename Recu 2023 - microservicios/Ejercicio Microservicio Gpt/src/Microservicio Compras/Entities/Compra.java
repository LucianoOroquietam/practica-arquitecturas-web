package Entities;

import java.util.List;

@Data
@Entity
public class Compra {
    @Id
    @GenetadValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    @OneToMany()
    private List<Producto> productos;
    @OneToMany()
    private Tienda tienda;


}
