package com.pguia.aghRecruitmentManager

import com.pguia.aghRecruitmentManager.controller.AghRMController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AghRecruitmentManagerApplication

fun main(args: Array<String>) {
	val ctx = runApplication<AghRecruitmentManagerApplication>(*args)
	val aghBean = ctx.getBean(AghRMController::class.java)
	aghBean.start()
}
