package com.example.challenge2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_my_friend.*
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import com.example.challenge2.data.CovidIndoService
import com.example.challenge2.data.apiRequestt
import com.example.challenge2.data.httpClientt
import com.example.challenge2.util.showLoading
import com.example.challenge2.util.tampilToast
import com.example.challenge2.util.dismissLoading
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class MyFriendFragment : Fragment() {
//    lateinit var listTeman : ArrayList<CovidIndoItem>

//    private fun simulasiDataTeman() {
//        listTeman = ArrayList()
//        listTeman.add(MyFriend("Anisa","Perempuan","anisa@gmail.com", "087676897656", "Malang"))
//        listTeman.add(MyFriend("Ridwan", "Laki-Laki", "ridwan@gmail.com", "089765897654", "Malang"))
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_my_friend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callApiGetCovidIndo()
//        tampilTeman(CovidIndo)
//        initView()

    }

    private fun callApiGetCovidIndo() {
        showLoading(context!!,swipeRefreshLayout)

        val httpClient = httpClientt()
        val apiRequest = apiRequestt<CovidIndoService>(httpClient)

        val call = apiRequest.getCovid()
        call.enqueue(object : Callback<List<CovidIndoItem>> {

            override fun onFailure(call: Call<List<CovidIndoItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<CovidIndoItem>>,
                response: Response<List<CovidIndoItem>>
            ) {
                dismissLoading(swipeRefreshLayout)

                when {
                    response.isSuccessful->

                        when {
                            response.body()?.size != 0 ->

                                tampilTeman(response.body()!!)

                            else -> {
                                tampilToast(context!!,"Berhasil")
                            }
                        }

                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }
            }

        })
    }

    private fun tampilTeman(CovidIndon:List<CovidIndoItem>) {
        rv_myfriend.layoutManager = LinearLayoutManager(context)
        rv_myfriend.adapter = MyFriendAdapter(context!!, CovidIndon as ArrayList<CovidIndoItem>) {

            val covidIndoo = it
            tampilToast(context!!, covidIndoo.dirawat)

        }
    }

//    private fun initView() {
////        simulasiDataTeman()
//        callApiGetCovidIndo()
//        tampilTeman()
//    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
