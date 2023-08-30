package com.crm.web.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Não é do Spring, e sim do Lombok
@Entity // é do jakarta, defini a estrutura que vai ser salva no banco de dados
@Table (name = "clientes")//  é do jakarta,
@AllArgsConstructor // vai configurar um construtor com todos os parâmetros
@NoArgsConstructor
public class Client {
    @Id // para dizer que é uma PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // está dizendo que o id é AUTO_INCREMENT
    private int id;
    @Column(length = 11) // dizer que é uma coluna com tamanho 11
    private String cpf;
    @Column(name = "primeiro_nome") // para dizer que o nome da coluna no banco de dados é "primeiro_nome"
    private String primeiroNome;
    @Column
    private String sobrenome;
    @Column // @Transient -> diz que esse atributo vai ser ignorado pelo hibernate
    private int idade;
    @Column
    private String email;

    // Não precisa gerar Gets e Sets, pois o "@Data" vai fazer isso
}
