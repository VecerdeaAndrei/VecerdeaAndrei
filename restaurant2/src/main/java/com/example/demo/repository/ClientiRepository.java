package com.example.demo.repository;

import com.example.demo.model.Angajati;
import com.example.demo.model.Clienti;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientiRepository {
    private JdbcTemplate jdbcTemplate;

    public ClientiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Clienti createUser(Clienti clienti){
        String sql = "insert into clienti1 values (null, ? ,? )";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, clienti.getName());
            preparedStatement.setString(2, clienti.getEmail());
            return preparedStatement;
        };

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator,generatedKeyHolder );
        clienti.setIduser(generatedKeyHolder.getKey().longValue());
        return clienti;
    }

    public Optional <Clienti> getByEmail(String email){
        String sql = "select * from clienti1 u where u.email = ?";
        RowMapper<Clienti> rowMapper = (resultSet, rwwNum)  ->{
            Clienti clienti = new Clienti();
            clienti.setIduser(resultSet.getInt("iduser"));
            clienti.setName(resultSet.getString("name"));
            clienti.setEmail(resultSet.getString("email"));
            return clienti;
        };
        List<Clienti> result = jdbcTemplate.query(sql,rowMapper, email);
        if(result != null && !result.isEmpty()){
            return Optional.of(result.get(0));
        }else {
            return Optional.empty();
        }

    }



}
