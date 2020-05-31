package com.pguia.aghRecruitmentManager.models

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name="d_guild_a_guild")
data class DiscordGuildAlbionGuild (
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

        @OneToOne
        val discordGuild: DiscordGuild,

        @OneToOne
        val albionGuild: AlbionGuild
): Serializable