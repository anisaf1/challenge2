package com.example.challenge2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge2.data.CovidProvService
import com.example.challenge2.data.apiRequest
import com.example.challenge2.data.httpClient
import com.example.challenge2.util.dismissLoading
import com.example.challenge2.util.tampilToast
import com.example.challenge2.util.showLoading
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_github.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_github, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetCovidProv()
    }

    private fun callApiGetCovidProv() {
        showLoading(context!!,swipRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<CovidProvService>(httpClient)

        val call = apiRequest.getCovidProv()
        call.enqueue(object: Callback<List<CovidProvItem>> {

            override fun onFailure(call:Call<List<CovidProvItem>>, t: Throwable) {
                dismissLoading(swipRefreshLayout)
            }

            override fun onResponse(call:Call<List<CovidProvItem>>, response:Response<List<CovidProvItem>>) {
                dismissLoading(swipRefreshLayout)

                when {
                    response.isSuccessful ->

                        when {
                            response.body()?.size != 0 ->
                               tampilCovidProv(response.body()!!)
                            else -> {
                                tampilToast(context!!, "Berhasil")
                            }

                        }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }

            }

        })
    }

    private fun tampilCovidProv(covidProv: List<CovidProvItem>){
        listCovidProv.layoutManager = LinearLayoutManager(context)
        listCovidProv.adapter = CovidProvAdapter(context!!,covidProv){

            val covidProvs = it
//            tampilToast(context!!, covidProvs.attributes)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}


