package dev.marcellogalhardo.anvilmodulemissing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import dev.marcellogalhardo.base.fragment.FragmentFactoryOwner
import dev.marcellogalhardo.feature1.Feature1Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val fragmentFactoryOwner = application as FragmentFactoryOwner
        supportFragmentManager.fragmentFactory = fragmentFactoryOwner.fragmentFactory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                setReorderingAllowed(true)
                replace(R.id.container, Feature1Fragment::class.java, intent?.extras)
            }
        }
    }
}
