package com.pguia.aghRecruitmentManager.models

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "a_guild")
data class AlbionMember (
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        val id: UUID?,

        @Version
        val version: Int,
        @ManyToOne
        val guild: AlbionGuild,

        val avgIp: Int,
        val name: String,
        val inGameId: String,
        val allyName: String,
        val allyId: String,
        val allyTag: String,
        val avatar: String,
        val avatarRing: String,
        val deathFame: Long,
        val killFame: Long,
        val fameRatio: Float,
        val pveTotal: Long,
        val gatheringFiber: Int,
        val gatheringHide: Int,
        val gatheringOre: Int,
        val gatheringRock: Int,
        val gatheringWood: Int,
        val craftingTotal: Int,
        val timeStemp: String

) : Serializable {
    override fun toString(): String {
        return "$avgIp,$name,$inGameId,$allyName,$allyId,$allyTag,$avatar,$avatarRing,$deathFame,$killFame,$fameRatio,$pveTotal,$gatheringFiber,$gatheringHide," +
                "$gatheringOre,$gatheringRock,$gatheringWood,$craftingTotal,$timeStemp"
    }
}

data class AlbionMemberCreation(
        val guild: AlbionGuild,
        val avgIp: Int,
        val name: String,
        val inGameId: String,
        val allyName: String,
        val allyId: String,
        val allyTag: String,
        val avatar: String,
        val avatarRing: String,
        val deathFame: Long,
        val killFame: Long,
        val fameRatio: Float,
        val pveTotal: Long,
        val gatheringFiber: Int,
        val gatheringHide: Int,
        val gatheringOre: Int,
        val gatheringRock: Int,
        val gatheringWood: Int,
        val craftingTotal: Int,
        val timeStemp: String
) : Serializable {
    companion object {
        fun from(g: AlbionMember): AlbionMemberCreation {
            return AlbionMemberCreation(
                    guild = g.guild,
                    avgIp = g.avgIp,
                    name = g.name,
                    inGameId = g.inGameId,
                    fameRatio = g.fameRatio,
                    killFame = g.killFame,
                    deathFame = g.deathFame,
                    timeStemp = g.timeStemp,
                    pveTotal = g.pveTotal,
                    gatheringFiber = g.gatheringFiber,
                    gatheringHide = g.gatheringHide,
                    gatheringOre = g.gatheringOre,
                    gatheringRock = g.gatheringRock,
                    gatheringWood = g.gatheringWood,
                    craftingTotal = g.craftingTotal,
                    allyName = g.allyName,
                    allyId = g.allyId,
                    avatar = g.avatar,
                    allyTag = g.allyTag,
                    avatarRing = g.avatarRing
            )
        }
    }
}