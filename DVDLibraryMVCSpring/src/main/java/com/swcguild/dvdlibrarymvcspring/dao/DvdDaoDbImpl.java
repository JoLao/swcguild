/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarymvcspring.dao;

import com.swcguild.dvdlibrarymvcspring.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author apprentice
 */
@Controller
public class DvdDaoDbImpl implements DvdDao {

    private String SQL_INSERT_DVD
            = "INSERT INTO dvd (videotype, title, releasedate, mpaarating, director, studio, reviews) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private String SQL_UPDATE_DVD
            = "UPDATE dvd SET videotype = ?, title = ?, releasedate = ?, mpaarating = ?, "
            + "director = ?, studio = ?, reviews = ? "
            + "WHERE dvd_id = ?";

    private String SQL_DELETE_DVD
            = "DELETE FROM dvd WHERE dvd_id = ?";

    private String SQL_SELECT_BY_TITLE
            = "SELECT * FROM dvd WHERE title = ?";

    private String SQL_SELECT_ALL
            = "SELECT * FROM dvd";
    
    private String SQL_SELECT_BY_ID
            = "SELECT * FROM dvd WHERE dvd_id = ?";
  
    private String SQL_SELECT_BY_DVD_BY_TITLE
            = "SELECT * FROM dvd WHERE title = ? AND videotype = 'DVD'";

    private String SQL_SELECT_BY_BLURAY_BY_TITLE
            = "SELECT * FROM dvd WHERE title = ? AND videotype = 'BluRay'";

    private String SQL_SELECT_ALL_BY_VIDEOTYOE
            = "SELECT * FROM dvd ORDER BY videotype";

    private String SQL_SELECT_LAST_N_YEAR_RELEASES
            = "SELECT * FROM dvd WHERE DATE_SUB(CURDATE(),INTERVAL ? YEAR) <= releasedate";

    private String SQL_SELECT_BY_MPAARATING
            = "SELECT * FROM dvd WHERE mpaarating = ?";

    private String SQL_SELECT_BY_DIRECTOR
            = "SELECT * FROM dvd WHERE director = ? ORDER BY mpaarating";

    private String SQL_SELECT_BY_STUDIO
            = "SELECT * FROM dvd WHERE studio = ?";

    private String SQL_GET_AVERAGE_AGE
            = "SELECT AVG( YEAR( CURDATE( ) ) - YEAR( releasedate ) )  FROM dvd";

    private JdbcTemplate jdbcTemplate;

    @Inject
    public DvdDaoDbImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void add(Dvd dvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                dvd.getVideoType(),
                dvd.getTitle(),
                dvd.getReleaseDate().toString(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getReviews());
        dvd.setDvdId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void edit(Dvd dvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                dvd.getVideoType(),
                dvd.getTitle(),
                dvd.getReleaseDate().toString(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getReviews(),
                dvd.getDvdId());
    }

    @Override
    public double getAverageAge() {
        return jdbcTemplate.queryForObject(SQL_GET_AVERAGE_AGE, Double.class);
    }

    @Override
    public Dvd getDvd(int dvdNumber) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new DvdMapper(), dvdNumber);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Map<String, List<Dvd>> getByDirectorGroupByRating(String director) {
       return jdbcTemplate.query(SQL_SELECT_BY_DIRECTOR, new DvdMapper(), director)
               .stream()
               .collect(Collectors.groupingBy(d -> d.getMpaaRating()));
    }

    @Override
    public List<Dvd> getByRating(String mpaaRating) {
        return jdbcTemplate.query(SQL_SELECT_BY_MPAARATING, new DvdMapper(), mpaaRating);
    }

    @Override
    public List<Dvd> getByStudio(String studio) {
        return jdbcTemplate.query(SQL_SELECT_BY_STUDIO, new DvdMapper(), studio);
    }

    @Override
    public List<Dvd> getByTitle(String title) {
        return jdbcTemplate.query(SQL_SELECT_BY_TITLE, new DvdMapper(), title);
    }

    @Override
    public List<Dvd> getReleasesInLastNYears(int years) {
        return jdbcTemplate.query(SQL_SELECT_LAST_N_YEAR_RELEASES, new DvdMapper(), years);
    }

    @Override
    public List<Dvd> listAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, new DvdMapper());
    }

    @Override
    public List<Dvd> listDvdByTitle(String title) {
        return jdbcTemplate.query(SQL_SELECT_BY_DVD_BY_TITLE, new DvdMapper(), title);
    }

    @Override
    public List<Dvd> listBluRayByTitle(String title) {
        return jdbcTemplate.query(SQL_SELECT_BY_BLURAY_BY_TITLE, new DvdMapper(), title);
    }

    @Override
    public Map<String, List<Dvd>> listAllGroupByVideoType() {
        return jdbcTemplate.query(SQL_SELECT_ALL, new DvdMapper())
                .stream()
                .collect(Collectors.groupingBy(d -> d.getVideoType()));
    }

    @Override
    public List<Dvd> listAllByTitle(String title) {
        return jdbcTemplate.query(SQL_SELECT_BY_TITLE, new DvdMapper(), title);
    }

    @Override
    public void remove(int dvdNumber) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdNumber);
    }

    @Override
    public Map<String, List<Dvd>> getByDirectorGroupByRating2(String director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class DvdMapper implements RowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int i) throws SQLException {
           Dvd d = new Dvd();
           d.setDvdId(rs.getInt("dvd_id"));
           d.setVideoType(rs.getString("videotype"));
           d.setTitle(rs.getString("title"));
           d.setReleaseDate(LocalDate.parse(rs.getString("releasedate"), DateTimeFormatter.ISO_DATE));
           d.setMpaaRating(rs.getString("mpaarating"));
           d.setDirector(rs.getString("director"));
           d.setStudio(rs.getString("studio"));
           d.setReviews(rs.getString("reviews"));
           return d;
        }
    
}
}
