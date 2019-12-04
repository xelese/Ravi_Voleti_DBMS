package edu.northeastern.cs5200.daos;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreateTableDaoTest {

  @Test
  public void createTable() {

    CreateTableImpl createTable = new CreateTableDao();

    createTable.createTable();

  }
}