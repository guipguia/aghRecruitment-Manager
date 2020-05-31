package com.pguia.aghRecruitmentManager.models

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name= "d_guild_d_member")
data class DiscordGuildMembers(
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

        @ManyToMany
        @JoinColumn(name="d_guild_id", referencedColumnName = "id")
        val discordGuild: List<DiscordGuild>,

        @ManyToMany
        @JoinColumn(name="d_member_id", referencedColumnName = "id")
        val discordMember: List<DiscordMember>
): Serializable
