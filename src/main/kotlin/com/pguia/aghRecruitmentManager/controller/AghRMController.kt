package com.pguia.aghRecruitmentManager.controller

import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import org.springframework.stereotype.Component

@Component
class AghRMController(
        private val token: String
) {
    fun start(){
        val builder = JDABuilder(AccountType.BOT)
                .setToken(token)

        builder.build().awaitReady()
    }
}