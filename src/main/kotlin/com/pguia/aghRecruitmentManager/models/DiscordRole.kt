package com.pguia.aghRecruitmentManager.models

import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "d_roles")
data class DiscordRole (
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(
                name = "UUID",
                strategy = "org.hibernate.id.UUIDGenerator"
        )
        val id: UUID?,

        @Version
        val version: Int,

        val name: String
): Serializable

@Entity
@Table(name = "d_member_roles")
data class DiscordMemberRole(
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

        @ManyToOne
        @JoinColumn(name="d_member_id")
        val members: DiscordMember,

        @ManyToOne
        @JoinColumn(name="d_roles_id")
        val role: DiscordRole

): Serializable

data class DiscordRoleCreation(
        val name: String
): Serializable

