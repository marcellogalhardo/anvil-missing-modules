package dev.marcellogalhardo.library1

import androidx.fragment.app.Fragment
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.marcellogalhardo.base.fragment.FragmentKey
import dev.marcellogalhardo.base.scope.AppScope
import javax.inject.Inject

class Library1Fragment @Inject constructor(
    dummyDependency: DummyDependency
) : Fragment(R.layout.library1_fragment)

class DummyDependency @Inject constructor()

// FIXME: This module has a valid contributesTo but the target MergeComponent lives in app.
//  Anvil will silently ignore it. If you check the generated dagger code, it will be:
//  ```
//      public final class DaggerMainComponent implements MainComponent {
//      (...)
//      private Map<Class<? extends Fragment>, Provider<Fragment>> mapOfClassOfAndProviderOfFragment() {
//        return Collections.<Class<? extends Fragment>, Provider<Fragment>>singletonMap(Feature1Fragment.class, (Provider) feature1FragmentProvider);
//      }
//      (...)
//  ```
//  Note that AnotherModule won't be added neither.
@[Module ContributesTo(AppScope::class)]
interface Library1FragmentModule {

    @[Binds IntoMap FragmentKey(Library1Fragment::class)]
    fun bindFragment(impl: Library1Fragment): Fragment
}