package dev.marcellogalhardo.anvilmodulemissing

import android.app.Application
import androidx.fragment.app.FragmentFactory
import dev.marcellogalhardo.base.fragment.FragmentFactoryOwner

class MainApplication : Application(), FragmentFactoryOwner {

    private val component = DaggerMainComponent.create()

    override val fragmentFactory: FragmentFactory
        get() = component.getFragmentFactory()
}