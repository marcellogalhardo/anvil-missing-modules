package dev.marcellogalhardo.library1

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dev.marcellogalhardo.base.scope.AppScope

// FIXME: Note this module will not be added to MainComponent neither.
@[Module ContributesTo(AppScope::class)]
interface AnotherModule {
    @Provides
    fun provideString(): String {
        return "Test"
    }
}