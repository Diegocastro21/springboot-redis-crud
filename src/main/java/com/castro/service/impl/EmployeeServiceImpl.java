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

    private static final String EMPLOYEE_KEY = "Employee";

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
        hashOperations.put(EMPLOYEE_KEY, employee.getId(), employee);
    }

    @Override
    public void update(Employee employee) {
        hashOperations.put(EMPLOYEE_KEY, employee.getId(), employee);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(EMPLOYEE_KEY, id);
    }

    @Override
    public Employee findById(Long id) {
        return hashOperations.get(EMPLOYEE_KEY, id);
    }

    @Override
    public List<Employee> getAllEmployees(String key) {
        return hashOperations.values(key);
    }

    @Override
    public List<Employee> findEmployeeById(List<Long> id) {
        return hashOperations.multiGet(EMPLOYEE_KEY, id);
    }

    @Override
    public Map<Long, Employee> getAll() {
        return hashOperations.entries(EMPLOYEE_KEY);
    }
}
