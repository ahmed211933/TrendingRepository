package com.ahmed.trending_task.trending.presentation.view.activity

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmed.trending_task.R


import com.ahmed.trending_task.trending.data.model.response.GithubResponse
import com.ahmed.trending_task.trending.presentation.view.adapter.FooterLoadingAdapter
import com.ahmed.trending_task.trending.presentation.view.adapter.HomeItemsAdapter
import com.ahmed.trending_task.trending.presentation.viewmodel.MakeenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import javax.inject.Inject
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import kotlin.collections.ArrayList


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    val TAG = "Looog"

    private lateinit var adapter: HomeItemsAdapter
    private lateinit var concatAdapter: ConcatAdapter
    private var footerAdapter = FooterLoadingAdapter()

    @Inject
    lateinit var viewModel : MakeenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
       // NetworkAvailable()
        observeScreenState()
        initRecyclerView()
        swipRefresh()
        menuClick()
        viewModel.getMakeenItems()

    }


    private fun initRecyclerView() {

        adapter = HomeItemsAdapter(ArrayList())
        concatAdapter = ConcatAdapter(adapter, footerAdapter)
        rvForecast.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)
        rvForecast.adapter = concatAdapter
    }

    private fun observeScreenState() {

        viewModel.screenState.observe(this , Observer {
            onScreenStateChanged(it)
        })
    }

    private fun onScreenStateChanged(state: MakeenViewModel.ScreenState?) {
        when (state) {
            is MakeenViewModel.ScreenState.Loading -> footerAdapter.setLoading()
            is MakeenViewModel.ScreenState.SuccessAPIResponse -> handleSuccess(state.data)
            is MakeenViewModel.ScreenState.ErrorLoadingFromApi -> handleErrorLoadingFromApi(state.error)
        }
    }

    private fun handleErrorLoadingFromApi(error: Throwable) {

        footerAdapter.showError{
            viewModel.getMakeenItems()
        }
    }

    private fun handleSuccess(data: ArrayList<GithubResponse>) {
        footerAdapter.setLoading(false)
        adapter.setList(data)
    }

   private fun  NetworkAvailable(){
       val connectionManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
       val networkInfo = connectionManager.activeNetworkInfo
       if (networkInfo != null && networkInfo.isConnected) {
           footerAdapter.showError{
               viewModel.getMakeenItems()
           }
       } else {
           footerAdapter.showError{
               viewModel.getMakeenItems()
           }
       }
    }

    private fun swipRefresh(){
        swiperefreshlayout.setOnRefreshListener(OnRefreshListener {
            //Changing the text when refresh
            adapter.clear()
            viewModel.getMakeenItems()
            swiperefreshlayout.isRefreshing = false
        })
    }

    private fun menuClick(){
        image_menu.setOnClickListener{
            showPopupMenu()
        }
    }
    // method to show popup menu
    private fun showPopupMenu(){
        val popup = PopupMenu(this,image_menu)

        popup.apply {
            // inflate the popup menu
            menuInflater.inflate(R.menu.popup_menu,menu)

        }
        popup.show()

        // finally, show the popup menu

    }
}