package com.example.challenge2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_my_friend.*

/**
 * A simple [Fragment] subclass.
 */
class MyFriendFragment : Fragment() {
    lateinit var listTeman : ArrayList<MyFriend>

    private fun simulasiDataTeman() {
        listTeman = ArrayList()
        listTeman.add(MyFriend("Anisa","Perempuan","anisa@gmail.com", "087676897656", "Malang"))
        listTeman.add(MyFriend("Ridwan", "Laki-Laki", "ridwan@gmail.com", "089765897654", "Malang"))
    }

    private fun tampilTeman() {
        rv_myfriend.layoutManager = LinearLayoutManager(activity)
        rv_myfriend.adapter = MyFriendAdapter(activity!!, listTeman)
    }


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

        initView()

    }

    private fun initView() {
        simulasiDataTeman()
        tampilTeman()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
