package dev.marcellogalhardo.feature1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.marcellogalhardo.base.fragment.FragmentKey
import dev.marcellogalhardo.base.scope.AppScope
import dev.marcellogalhardo.library1.Library1Fragment
import javax.inject.Inject

class Feature1Fragment @Inject constructor(
    dummyDependency: DummyDependency
) : Fragment(R.layout.feature1_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
//            FIXME: This line crashes the application because Library1FragmentModule will not be
//              added to right component.
            childFragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.container, Library1Fragment::class.java, arguments)
            }
        }
    }
}

class DummyDependency @Inject constructor()

@[Module ContributesTo(AppScope::class)]
interface Feature1FragmentModule {

    @[Binds IntoMap FragmentKey(Feature1Fragment::class)]
    fun bindFragment(impl: Feature1Fragment): Fragment
}
