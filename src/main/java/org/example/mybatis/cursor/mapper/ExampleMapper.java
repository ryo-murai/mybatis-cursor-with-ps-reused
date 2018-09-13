package org.example.mybatis.cursor.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

@Mapper
public interface ExampleMapper {
  List<String> getByList();

  Cursor<String> getByCursor();
}
