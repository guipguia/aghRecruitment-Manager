package com.pguia.aghRecruitmentManager.repositories

import com.pguia.aghRecruitmentManager.models.AlbionMember
import com.pguia.aghRecruitmentManager.models.AlbionMemberCreation
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AlbionMemberRepository(
        @Qualifier("JPAAlbionGuildRepository")
        private val jpaRepository: JPAAlbionMemberRepository
) : JPAAlbionMemberRepository by jpaRepository{
    fun create(model: AlbionMemberCreation) {
        val gm = AlbionMember(
                id = null,
                version = 1,
                guild = model.guild,
                name = model.name,
                inGameId = model.inGameId,
                avgIp = model.avgIp,
                allyTag = model.allyTag,
                allyId = model.allyId,
                allyName = model.allyName,
                avatar = model.avatar,
                avatarRing = model.avatarRing,
                deathFame = model.deathFame,
                killFame = model.killFame,
                fameRatio = model.fameRatio,
                pveTotal = model.pveTotal,
                gatheringFiber = model.gatheringFiber,
                gatheringHide = model.gatheringHide,
                gatheringOre = model.gatheringOre,
                gatheringRock = model.gatheringRock,
                gatheringWood = model.gatheringWood,
                craftingTotal = model.craftingTotal,
                timeStemp = model.timeStemp
        )
        jpaRepository.save(gm)
    }

    fun read(): List<AlbionMember>{
        return findAll()
    }

    fun readByInGameId(id: String): AlbionMember?{
        return findByInGameId(id)
    }
}

interface JPAAlbionMemberRepository: JpaRepository<AlbionMember, UUID> {
    fun findByInGameId(id: String): AlbionMember?
}