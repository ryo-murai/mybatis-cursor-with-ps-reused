package org.example.mybatis.cursor.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;

@Mapper
public interface ExampleMapper {
  List<String> getByList();

  Cursor<String> getByCursor();

  void collect(ResultHandler<String> resultHandler);
}
