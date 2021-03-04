package dev.marcellogalhardo.base.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.squareup.anvil.annotations.ContributesBinding
import dev.marcellogalhardo.base.scope.AppScope
import javax.inject.Inject
import javax.inject.Provider

@ContributesBinding(AppScope::class, FragmentFactory::class)
class MultibindingFragmentFactory @Inject constructor(
    private val providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)
        return providers[fragmentClass]?.get() ?: super.instantiate(classLoader, className)
    }
}