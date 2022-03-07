package org.rjansen.structures.jansenpizza.repository.dao

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class LocationDAO(
    var cityName: String,
    var countryName: String,
    var iso2: String
) {

    constructor(jdbcTemplate: JdbcTemplate) : this("", "", "") {
        this.jdbcTemplate = jdbcTemplate
    }

    private lateinit var jdbcTemplate: JdbcTemplate

    companion object {
        const val FIND_CITY_BY_NAME = "SELECT * FROM CITIES WHERE NAME=?"
        const val FIND_COUNTRY_BY_NAME = "SELECT * FROM COUNTRIES WHERE NAME=?"
    }

    fun getCity(name: String): LocationDAO {
        return jdbcTemplate.queryForObject(FIND_CITY_BY_NAME, CityMapper(), name)
            ?: throw RuntimeException("City not found by $name")
    }

    fun getCountry(name: String): LocationDAO {
        return jdbcTemplate.queryForObject(FIND_COUNTRY_BY_NAME, CountryMapper(), name)
            ?: throw RuntimeException("Country not found by $name")
    }
}

internal class CityMapper : RowMapper<LocationDAO> {

    override fun mapRow(resultSet: ResultSet, i: Int): LocationDAO {
        return LocationDAO(
            cityName = resultSet.getString("name"),
            countryName = resultSet.getString("country_name"),
            iso2 = ""
        )
    }
}

internal class CountryMapper : RowMapper<LocationDAO> {

    override fun mapRow(resultSet: ResultSet, i: Int): LocationDAO {
        return LocationDAO(
            cityName = "",
            countryName = resultSet.getString("name"),
            iso2 = resultSet.getString("iso2")
        )
    }
}