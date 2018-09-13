package org.example.mybatis.cursor.mapper;

import org.apache.ibatis.cursor.Cursor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisCursorTest {

  @Autowired
  private ExampleMapper mapper;

  @Transactional
  @Sql(statements = {
    "insert into mytable values ('qwerty');",
    "insert into mytable values ('asdfgh');",
    "insert into mytable values ('zxcvbn');",
  })
  @Test
  public void testCursor() throws IOException {
    Cursor<String> cursor = mapper.getByCursor();
    cursor.forEach(System.out::println);
    cursor.close();

    // 2nd time
    cursor = mapper.getByCursor();
    cursor.forEach(System.out::println);
    cursor.close();
  }
}
