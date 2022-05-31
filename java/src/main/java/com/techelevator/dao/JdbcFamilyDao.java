package com.techelevator.dao;

import com.techelevator.model.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcFamilyDao implements FamilyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getFamilyNameByFamilyId(Long familyId) {
        String familyName = null;

        String sql = "SELECT family_name FROM family WHERE family_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        if (results.next()) {
            familyName = results.getString("family_name");
        }
        return familyName;
    }

    @Override
    public Long getFamilyIdByFamilyName(String name) {
        Long familyId = null;

        String sql = "SELECT family_id FROM family WHERE family_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        if (results.next()) {
            familyId = results.getLong("family_id");
        }

        return familyId;
    }

    public Family getFamilyById(Long familyId) {
        Family family = null;

        String sql = "SELECT family_id, family_name FROM family WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);

        if (results.next()) {
            family = mapRowToFamily(results);
        }
        return family;
    }

    @Override
    public Family makeNewFamily(Family newFam) {
        Long returnedFamilyId;
        Family family = new Family();

        String sql = "INSERT INTO family (family_name) VALUES (?) RETURNING family_id;";
        returnedFamilyId = jdbcTemplate.queryForObject(sql, Long.class, newFam.getFamilyName());
        //jdbcTemplate.update(sql, newFam.getFamilyName());

        return getFamilyById(returnedFamilyId);
    }

    private Family mapRowToFamily(SqlRowSet results) {
        Family family = new Family();

        family.setFamilyId(results.getLong("family_id"));
        family.setFamilyName(results.getString("family_name"));

        return family;
    }
}
