package com.pguia.aghRecruitmentManager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AghRecruitmentManagerApplication

fun main(args: Array<String>) {
	runApplication<AghRecruitmentManagerApplication>(*args)
	println("Working :)")
}
