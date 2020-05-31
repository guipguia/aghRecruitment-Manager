package com.pguia.aghRecruitmentManager.interactors


import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import org.slf4j.LoggerFactory
import java.awt.Color
import java.io.IOException


abstract class AbstractSimpleCmd(
        private val label: String
) {
    fun handle(event: GuildMessageReceivedEvent): Boolean{
        val msg = event.message.contentRaw
        return if(msg.startsWith(label)){
            run(event)
            true
        }else{
            false
        }
    }

    abstract fun run(event: GuildMessageReceivedEvent)

    fun errorPrivateMsg(to: User, msg: String){
        val eb = EmbedBuilder() //Creates the embed.
        eb.setTitle("ERROR:")
        eb.setColor(Color.RED)
        eb.addField("ERROR: ", msg, false)
        try{
            to.openPrivateChannel().complete().sendMessage(eb.build()).queue()
        }catch (error: IOException){
            val logger = LoggerFactory.getLogger(AbstractSimpleCmd::class.java)
            logger.info(error.toString())
        }
    }

    fun successPrivateMsg(to: User, msg: String){
        val eb = EmbedBuilder()
        eb.setTitle("Success:")
        eb.setColor(Color.GREEN)
        eb.addField("Success:", msg, false)
        try{
            to.openPrivateChannel().complete().sendMessage(eb.build()).queue()
        }catch (error: IOException){
            val logger = LoggerFactory.getLogger(AbstractSimpleCmd::class.java)
            logger.info(error.toString())
        }
    }
}