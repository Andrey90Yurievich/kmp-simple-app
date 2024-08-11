package org.company.app.navigation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController



//создания CompositionLocal
//Существует два API для создания CompositionLocal :
//compositionLocalOf : изменение значения, предоставленного во время рекомпозиции, делает недействительным только тот контент, который считывает свое current значение.
//staticCompositionLocalOf : в отличие от compositionLocalOf , чтение staticCompositionLocalOf не отслеживается Compose. Изменение значения приводит к перекомпоновке всей лямбды content , в которой указан CompositionLocal , а не только тех мест, где current значение считывается в композиции.
//Если значение, предоставленное CompositionLocal , вряд ли изменится или никогда не изменится, используйте staticCompositionLocalOf чтобы получить преимущества в производительности.
val LocalNavHost = staticCompositionLocalOf<NavHostController> { error("No default nav host") } //это инструмент для неявной передачи данных через Composition