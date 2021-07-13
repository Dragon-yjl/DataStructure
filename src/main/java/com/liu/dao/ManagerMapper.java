package com.liu.dao;

import com.liu.model.Manager;

public interface ManagerMapper {
    Manager selectManagerByNameAndPassword(Manager manager);
}
