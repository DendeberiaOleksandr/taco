//package com.dendeberia.taco.repositories;
//
//import com.dendeberia.taco.entities.Order;
//import com.dendeberia.taco.entities.Taco;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class JdbcOrderRepositoryImplementation implements OrderRepository {
//
//    private final SimpleJdbcInsert orderInserter;
//    private final SimpleJdbcInsert orderTacoInserter;
//    private final ObjectMapper objectMapper;
//
//    @Autowired
//    public JdbcOrderRepositoryImplementation(JdbcTemplate jdbcTemplate){
//        this.orderInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("Taco_Order").usingGeneratedKeyColumns("id");
//
//        this.orderTacoInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("Taco_Order_Tacos");
//
//        this.objectMapper = new ObjectMapper();
//
//    }
//
//    @Override
//    public Order save(Order order) {
//        order.setPlacedAt(new Date());
//
//        long orderId = setOrderInfo(order);
//        order.setId(orderId);
//
//        List<Taco> tacos = order.getTacos();
//
//        for (Taco taco : tacos) {
//            saveTacoToOrder(taco, orderId);
//        }
//
//        return order;
//    }
//
//    private long setOrderInfo(Order order){
//        Map<String, Object> values = objectMapper.convertValue(order, Map.class);
//
//        values.put("placedAt", order.getPlacedAt());
//
//        return orderInserter.executeAndReturnKey(values). longValue();
//
//    }
//
//    private void saveTacoToOrder(Taco taco, long orderId){
//        Map<String, Object> values = new HashMap<>();
//        values.put("tacoOrder", orderId);
//        values.put("taco", taco.getId());
//        orderTacoInserter.execute(values);
//    }
//}
