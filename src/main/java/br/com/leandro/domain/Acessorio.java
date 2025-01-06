package br.com.leandro.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_acessorio")
    @SequenceGenerator(name = "seq_id_acessorio", sequenceName = "seq_acessorio_id", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "nome")
    private String nome;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "TB_CARRO_ACESSORIO",
            joinColumns = {@JoinColumn(name = "id_acessorio_fk")},
            inverseJoinColumns = {@JoinColumn(name = "id_carro_fk")}
    )
    private List<Carro> carros;

    public String getCodigo() {
        return codigo;
    }

    public Acessorio(){
        this.carros = new ArrayList<>();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public void adicionarCarro(Carro carro){
        if (!carros.contains(carro)) {
            this.carros.add(carro);
            carro.adicionarAcessorio(this);
        }
    }
}
