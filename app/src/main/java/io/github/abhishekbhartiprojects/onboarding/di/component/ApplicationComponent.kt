package io.github.abhishekbhartiprojects.onboarding.di.component

import dagger.Component
import io.github.abhishekbhartiprojects.onboarding.di.module.ApplicationModule

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
}