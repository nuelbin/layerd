package com.example.layerd.repository;

import com.example.layerd.dto.MemoResponseDto;
import com.example.layerd.entity.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class JdbcTemplateMemoRepository implements MemoRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public MemoResponseDto savaMemo(Memo memo) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("memo").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", memo.getTitle());
        parameters.put("contents", memo.getContents());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new MemoResponseDto(key.longValue(), memo.getTitle(), memo.getContents());

    }

    @Override
    public List<MemoResponseDto> findAllMemos() {
        return List.of();
    }

    @Override
    public Memo findMemoById(Long id) {
        return null;
    }

    @Override
    public void deleteMemo(Long id) {

    }
}
