package com.crm.web.repositories;
import com.crm.web.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    // void deleteByName(String nome); // usar a convenção de nome, nesse ex: deleteByName.
    long deleteByNameAndEmail(String nome, String email); // Outra forma de fazer, quando se quer usar 2 parâmetros

    long countByName(String nome); // contar quantos clientes tem com o mesmo nome

}


