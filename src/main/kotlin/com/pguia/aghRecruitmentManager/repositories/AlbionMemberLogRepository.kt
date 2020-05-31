package com.pguia.aghRecruitmentManager.repositories

import com.pguia.aghRecruitmentManager.models.AlbionMemberLog
import com.pguia.aghRecruitmentManager.models.AlbionMemberLogCreation
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AlbionMemberLogRepository(
        @Qualifier("JPAAlbionMemberLogRepository")
        private val jpaRepository: JPAAlbionMemberLogRepository
) : JPAAlbionMemberLogRepository by jpaRepository {
    fun create(model: AlbionMemberLogCreation){
        val aml = AlbionMemberLog(
                id = null,
                version = 1,
                createdAt = System.currentTimeMillis(),
                updatedAt = System.currentTimeMillis(),
                playerName = model.playerName,
                playerId = model.playerId,
                pveTotal = model.pveTotal,
                gatheringTotal = model.gatheringTotal,
                craftingTotal = model.craftingTotal,
                guildId = model.guildId,
                guildName = model.guildName
        )
        jpaRepository.save(aml)
    }

    fun read(): List<AlbionMemberLog>{
        return findAll()
    }

    fun readByPlayerName(name: String): AlbionMemberLog?{
        return findByPlayerName(name)
    }

    fun readByGuildName(name: String): List<AlbionMemberLog>?{
        return findByGuildName(name)
    }
}


interface JPAAlbionMemberLogRepository: JpaRepository<AlbionMemberLog, UUID> {
    fun findByPlayerName(name: String): AlbionMemberLog?
    fun findByGuildName(name: String): List<AlbionMemberLog>?
}