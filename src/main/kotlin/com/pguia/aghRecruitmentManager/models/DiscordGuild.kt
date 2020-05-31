package com.pguia.aghRecruitmentManager.models

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "d_guild")
data class DiscordGuild (
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
        val name: String,
        val region: String,

        @ManyToMany
        @JoinTable(
                name="d_guild_d_member",
                joinColumns=[ JoinColumn(name="d_guild_id") ],
                inverseJoinColumns=[ JoinColumn(name="d_member_id") ]
        )
        val members: List<DiscordMember>
): Serializable

data class DiscordGuildCreation(
        val discordId: String,
        val name: String,
        val region: String
): Serializable