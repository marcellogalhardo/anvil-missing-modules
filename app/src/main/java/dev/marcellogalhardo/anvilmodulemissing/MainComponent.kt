package dev.marcellogalhardo.anvilmodulemissing

import androidx.fragment.app.FragmentFactory
import com.squareup.anvil.annotations.MergeComponent
import dev.marcellogalhardo.base.scope.AppScope
import dev.marcellogalhardo.base.scope.SingleIn

@MergeComponent(AppScope::class)
@SingleIn(AppScope::class)
interface MainComponent {
    fun getFragmentFactory(): FragmentFactory
}