package com.pguia.aghRecruitmentManager.models

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "d_member")
data class DiscordMember (
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
        val discordId: String,
        val username: String,
        val discriminator: Int
):Serializable

data class DiscordMemberCreation(
        val discordId: String,
        val username: String,
        val discriminator: Int
):Serializable

