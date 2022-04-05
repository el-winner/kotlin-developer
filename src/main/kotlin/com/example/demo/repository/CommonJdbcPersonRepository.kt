package com.example.demo.repository

import com.example.demo.domain.PersonModel
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementCreator
import org.springframework.stereotype.Repository

@Primary
@Repository
class CommonJdbcPersonRepository(
    private val jdbcTemplate: JdbcTemplate
) : PersonRepository {

    override fun getPerson(id: Long): PersonModel {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement(SELECT_BY_ID)
            ps.setLong(1, id)
            ps
        }
        return jdbcTemplate
            .query(statementCreator) { rs, _ ->
                PersonModel(
                    rs.getLong("id"),
                    rs.getString("person_name"),
                    rs.getInt("age")
                )
            }[0]
    }

    override fun getPersons(): List<PersonModel> {
        return jdbcTemplate
            .query(
                "SELECT * FROM persons"
            ) { rs, _ ->
                PersonModel(
                    rs.getLong("id"),
                    rs.getString("person_name"),
                    rs.getInt("age")
                )
            }
    }

    override fun getPersonsByAge(age: Int): List<PersonModel> {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement(SELECT_BY_AGE)
            ps.setInt(1, age)
            ps
        }
        return jdbcTemplate
            .query(statementCreator) { rs, _ ->
                PersonModel(
                    rs.getLong("id"),
                    rs.getString("person_name"),
                    rs.getInt("age")
                )
            }
    }

    override fun savePerson(person: PersonModel) {
        val statementCreator = PreparedStatementCreator { con ->
            val ps = con.prepareStatement(INSERT_PERSON)
            ps.setString(1, person.name)
            ps.setInt(2, person.age)
            ps
        }
        jdbcTemplate.update(statementCreator)
    }

    companion object {
        private const val SELECT_BY_ID = "SELECT * FROM persons WHERE id=?"

        private const val SELECT_BY_AGE = "SELECT * FROM persons WHERE age=?"

        private const val INSERT_PERSON = "INSERT INTO persons (person_name, age) VALUES (?, ?)"
    }
}
