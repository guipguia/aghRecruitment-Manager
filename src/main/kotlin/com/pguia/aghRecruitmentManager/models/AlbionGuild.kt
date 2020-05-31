package com.pguia.aghRecruitmentManager.models

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "a_guild")
data class AlbionGuild (
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

        val name: String,
        val founderName: String,
        val founderId: String,
        val foundedAt: Long,
        val killFame: Long,
        val deathFame: Long
): Serializable

data class AlbionGuildCreation (
        val name: String,
        val founderName: String,
        val founderId: String,
        val foundedAt: Long,
        val killFame: Long,
        val deathFame: Long
): Serializable