package leao.mainar.projetofinalapispringboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Component
@Entity
@Table(name = "hospede")
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospede")
    private long id;

    @Column(name = "nome")
    @NotNull(message = "Dados Invalidos")
    private String name;

    @Column(name = "idade")
    @NotNull(message = "Dados Invalidos")
    private byte age;

    @Column(name = "telefone")
    @NotNull(message = "Numero Invalidos")
    private String telephone;

    @Column(name = "CPF")
    @NotNull(message = "CPF Invalido")
    private long cpf;

    @Column(name = "RG")
    private String registroGeral;

    @Column(name = "check_in")
    @NotNull(message = "Data Invalida")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date check_in;

    @Column(name = "check_out")
    @NotNull(message = "Data Invalida")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date check_out;
}
