//package com.dendeberia.taco.repositories;
//
//import com.dendeberia.taco.entities.Ingredient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Repository
//public class JdbcIngredientRepositoryImplementation implements IngredientRepository {
//    private JdbcTemplate jdbcTemplate;
//    private IngredientRowMapper ingredientRowMapper;
//
//    @Autowired
//    JdbcIngredientRepositoryImplementation(JdbcTemplate jdbcTemplate, IngredientRowMapper ingredientRowMapper){
//        this.jdbcTemplate = jdbcTemplate;
//        this.ingredientRowMapper = ingredientRowMapper;
//    }
//
//    @Override
//    public Iterable<Ingredient> findAll() {
//        return jdbcTemplate.query("select id, name, type from Ingredient", ingredientRowMapper);
//    }
//
//    @Override
//    public Ingredient findOne(String id) {
//        return jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?", ingredientRowMapper, id);
//    }
//
//    @Override
//    public Ingredient save(Ingredient ingredient) {
//        jdbcTemplate.update("insert into Ingredient (id, name, type) VALUES(?, ?, ?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
//        return ingredient;
//    }
//
//}
