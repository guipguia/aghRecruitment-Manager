package com.pguia.aghRecruitmentManager.repositories

import com.pguia.aghRecruitmentManager.models.AlbionGuild
import com.pguia.aghRecruitmentManager.models.AlbionGuildCreation
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AlbionGuildRepository(
        @Qualifier("JPAAlbionGuildRepository")
        private val jpaRepository: JPAAlbionGuildRepository
) : JPAAlbionGuildRepository by jpaRepository{
    fun create(model: AlbionGuildCreation){
        val ag = AlbionGuild(
                id = null,
                version = 1,
                createdAt = System.currentTimeMillis(),
                updatedAt = System.currentTimeMillis(),
                name = model.name,
                founderName = model.founderName,
                founderId = model.founderId,
                foundedAt = model.foundedAt,
                killFame = model.killFame,
                deathFame = model.deathFame
        )
        jpaRepository.save(ag)
    }

    fun read(): List<AlbionGuild>{
        return findAll()
    }

    fun readByGuildName(name: String): AlbionGuild?{
        return findByName(name)
    }

}

interface JPAAlbionGuildRepository: JpaRepository<AlbionGuild, UUID> {
    fun findByName(name: String): AlbionGuild?
}