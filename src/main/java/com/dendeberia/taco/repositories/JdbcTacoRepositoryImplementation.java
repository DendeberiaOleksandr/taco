//package com.dendeberia.taco.repositories;
//
//import com.dendeberia.taco.entities.Ingredient;
//import com.dendeberia.taco.entities.Taco;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Timestamp;
//import java.sql.Types;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Objects;
//
//@Repository
//public class JdbcTacoRepositoryImplementation implements TacoRepository {
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcTacoRepositoryImplementation(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Taco save(Taco taco) {
//        long tacoId = setTacoInfo(taco);
//        taco.setId(tacoId);
//
//        for(Ingredient tacoIngredient : taco.getIngredients()){
//            saveIngredientToTaco(tacoIngredient, tacoId);
//        }
//
//        return taco;
//    }
//
//    private long setTacoInfo(Taco taco){
//        taco.setCreatedAt(new Date());
//
//        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreatorFactory(
//                "insert into Taco (name, createdAt) values (?, ?)", Types.VARCHAR, Types.TIMESTAMP
//        ).newPreparedStatementCreator(Arrays.asList(
//                taco.getName(), new Timestamp(taco.getCreatedAt().getTime())
//        ));
//
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(preparedStatementCreator, keyHolder);
//
//        return keyHolder.getKey().longValue();
//    }
//
//    private void saveIngredientToTaco(Ingredient tacoIngredient, long tacoId){
//        jdbcTemplate.update("insert into Taco_Ingredients (taco, ingredient) values (?, ?)", tacoId, tacoIngredient.getId());
//    }
//}
