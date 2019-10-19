package com.example.recipesproject.recipes.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipesproject.R
import com.example.recipesproject.recipes.presentation.vm.RecipesViewModel
import com.example.recipesproject.util.Resource
import kotlinx.android.synthetic.main.activity_recipes.*
import org.koin.android.viewmodel.ext.android.viewModel

class RecipesActivity : AppCompatActivity() {

    private val recipesViewModel: RecipesViewModel by viewModel()
    private val recipesAdapter = RecipesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)
        initUI()
        observeViewModel()
    }

    private fun initUI() {
        rvRecipes.layoutManager = LinearLayoutManager(this)
        rvRecipes.adapter = recipesAdapter
        swipeRefresh.setOnRefreshListener { recipesViewModel.getRecipes() }
        recipesViewModel.getRecipes()
    }

    private fun observeViewModel() {
        recipesViewModel.recipes.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Success -> {
                    hideLoading()
                    recipesAdapter.setRecipes(it.data!!)
                }
                is Resource.Error -> {
                    hideLoading()
                    recipesAdapter.setRecipes(it.data!!)
                    showToast(it.message!!)
                }
            }
        })
    }

    private fun showLoading() {
        swipeRefresh.isRefreshing = true
        rvRecipes.visibility = View.GONE
    }

    private fun hideLoading() {
        swipeRefresh.isRefreshing = false
        rvRecipes.visibility = View.VISIBLE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
