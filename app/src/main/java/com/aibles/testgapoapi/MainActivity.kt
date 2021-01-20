package com.aibles.testgapoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.aibles.testgapoapi.presentation.adapter.ViewPagerAdapter
import com.aibles.testgapoapi.presentation.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTab()
        makeCurrentFragment(NewsfeedFragment())
        setupNavBottom()
    }

    private fun setupNavBottom() {
        bottom_nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.icon_home -> makeCurrentFragment(NewsfeedFragment())
                R.id.icon_account -> makeCurrentFragment(DetailFragment())
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main, fragment)
            commit()
        }

    private fun setupTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FollowFragment(),"Theo dõi")
        adapter.addFragment(NewsfeedFragment(),"Cho bạn")
        adapter.addFragment(FootballFragment(),"Bóng đá")
        adapter.addFragment(TechnologyFragment(),"Công nghệ")
        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

    }
}