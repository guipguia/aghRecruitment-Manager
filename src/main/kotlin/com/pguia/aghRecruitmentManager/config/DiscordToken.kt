package com.pguia.aghRecruitmentManager.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DiscordToken {
    @Bean
    fun token() : String?{
        return System.getenv("DISCORD_TOKEN") ?: null
    }
}