package br.com.leandro.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MONTADORA")
public class Montadora {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_mont")
    @SequenceGenerator(name = "seq_id_mont", sequenceName = "seq_mont_id", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @OneToMany(mappedBy = "montadora")
    private List<Carro> carros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
