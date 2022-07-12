package com.castro.service.impl;

import com.castro.dto.Employee;
import com.castro.service.EmployeeService;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {

    private static final String EMPLOYEE_KEY = "";

    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Employee> hashOperations;

    public EmployeeServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees(String key) {
        return null;
    }

    @Override
    public List<Employee> findEmployeeById(List<Long> id) {
        return null;
    }

    @Override
    public Map<Long, Employee> getAll() {
        return null;
    }
}
