package com.pguia.aghRecruitmentManager.repositories

import com.pguia.aghRecruitmentManager.models.DiscordGuild
import com.pguia.aghRecruitmentManager.models.DiscordGuildCreation
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class DiscordGuildRepository(
        @Qualifier("JPADiscordGuildRepository")
        private val jpaRepository: JPADiscordGuildRepository
) : JPADiscordGuildRepository by jpaRepository {
    fun create(model: DiscordGuildCreation){
        val dg = DiscordGuild(
                id = null,
                version = 1,
                createdAt = System.currentTimeMillis(),
                updatedAt = System.currentTimeMillis(),
                discordId = model.discordId,
                name = model.name,
                region = model.region,
                members = emptyList()
        )
        jpaRepository.save(dg)
    }

    fun read(): List<DiscordGuild>{
        return findAll()
    }

    fun readByName(name: String): DiscordGuild?{
        return findByName(name)
    }

    fun readByRegion(region: String): DiscordGuild?{
        return findByRegion(region)
    }
}

interface JPADiscordGuildRepository: JpaRepository<DiscordGuild, UUID> {
    fun findByName(name: String): DiscordGuild?
    fun findByRegion(region: String): DiscordGuild?
}