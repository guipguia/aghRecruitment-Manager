package com.pguia.aghRecruitmentManager.models

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "a_member_log")
data class AlbionMemberLog (
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        val id: UUID?,

        @Version
        val version: Int,

        val createdAt: Long,
        val updatedAt: Long,

        val playerName: String,
        val playerId: String,
        val pveTotal: Long,
        val gatheringTotal: Long,
        val craftingTotal: Long,
        val guildName: String,
        val guildId: String
):Serializable

data class AlbionMemberLogCreation(
    val playerName: String,
    val playerId: String,
    val pveTotal: Long,
    val gatheringTotal: Long,
    val craftingTotal: Long,
    val guildName: String,
    val guildId: String
): Serializable