package com.mostafa.jakewhartontask.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mostafa.jakewhartontask.R
import com.mostafa.jakewhartontask.data.DataManger
import com.mostafa.jakewhartontask.data.local.dao.UserDao
import com.mostafa.jakewhartontask.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var  mDataManager: DataManger

    @Inject
    lateinit var mUserDao : UserDao

    lateinit var mMainVM : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        val mBinding : ActivityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        mMainVM = MainViewModel(mDataManager)
        mBinding.mainVM = mMainVM

        mMainVM.fetchData(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mMainVM.dispose()
    }
}
