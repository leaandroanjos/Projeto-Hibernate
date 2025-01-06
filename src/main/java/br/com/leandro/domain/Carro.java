package br.com.leandro.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_carro")
    @SequenceGenerator(name = "seq_id_carro", sequenceName = "seq_carro_id", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_montadora_fk",
    foreignKey = @ForeignKey(name = "fk_carro_montadora"),
    referencedColumnName = "id", nullable = false)
    private Montadora montadora;

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy = "carros")
    private List<Acessorio> acessorios;

    public Carro(){
        this.acessorios = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
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

    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void adicionarAcessorio(Acessorio acessorio){
        if (!acessorios.contains(acessorio)) {
            this.acessorios.add(acessorio);
            acessorio.adicionarCarro(this); // Sincroniza do outro lado
        }
    }
}
