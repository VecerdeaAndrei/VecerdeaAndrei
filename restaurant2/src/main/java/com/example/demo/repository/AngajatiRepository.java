package com.example.demo.repository;

import com.example.demo.model.Angajati;
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
public class AngajatiRepository {
    private JdbcTemplate jdbcTemplate;

    public AngajatiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Angajati createUser(Angajati angajati){
        String sql = "insert into angajati1 values (null, ? ,? ,?)";
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, angajati.getName());
            preparedStatement.setString(2, angajati.getEmail());
            preparedStatement.setString(3, angajati.getCity());
            return preparedStatement;
        };

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator,generatedKeyHolder );
        angajati.setIduser(generatedKeyHolder.getKey().longValue());
        return angajati;
    }

    public Optional <Angajati> getByEmail(String email){
        String sql = "select * from angajati1 u where u.email = ?";
        RowMapper<Angajati> rowMapper = (resultSet, rwwNum)  ->{
            Angajati angajati = new Angajati();
            angajati.setIduser(resultSet.getInt("iduser"));
            angajati.setName(resultSet.getString("name"));
            angajati.setEmail(resultSet.getString("email"));
            angajati.setCity(resultSet.getString("city"));
            return angajati;
        };
        List<Angajati> result = jdbcTemplate.query(sql,rowMapper, email);
        if(result != null && !result.isEmpty()){
            return Optional.of(result.get(0));
        }else {
            return Optional.empty();
        }

    }

    public void  updateAngajati(Angajati angajati) {
        String sql = "update angajati1  set angajati1.name= ? , angajati1.city = ? where angajati1.iduser = ?";
        jdbcTemplate.update(sql,angajati.getName(),angajati.getCity(),angajati.getIduser());

    }
}
