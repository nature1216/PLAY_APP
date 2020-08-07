package com.example.play_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_play_list.*

class PlayListActivity : AppCompatActivity() {

    private val item = arrayListOf<String>(
        "1일 클래스", "PC방", "VR카페", "계곡가기", "공기놀이", "공방", "궁 가기", "노래방", "놀이공원", "농구", "달리기", "당구장", "동물원", "드라마보기",
        "등산", "디스코팡팡 타기", "딸기게임", "땅따먹기", "만화카페", "바니바니 게임", "바다가기", "방탈출카페", "밸런스게임", "번지점프", "베이킹하기", "보드게임",
        "볼링장", "빙고게임", "산책하기", "셀카찍기", "셀프네일하기", "손병호게임", "쇼핑", "수영", "스카이다이빙", "스케이트장", "스쿠버다이빙", "스키장 가기",
        "슬라임카페", "식물원", "썰매장", "쎄쎄쎄", "아이엠그라운드 게임", "암흑카페", "야구", "영화", "오락실", "오렌지게임", "오목", "요리하기", "이미지사진 찍기",
        "인생네컷 찍기", "장문복게임", "전시회", "종이접기", "진실게임", "쪽팔려게임", "축구", "카드게임", "카페투어", "컬러링북", "클라이밍", "클레오파트라 게임",
        "타로", "틀린그림찾기", "피크닉", "피포페인팅", "향수 만들기", "홍삼게임", "화장품 만들기"
    )
    private lateinit var mAdpater : MyCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_list)
        play_list_back_button.setOnClickListener {
            finish()
        }


        val listView = findViewById<ListView>(R.id.listView)
        mAdpater = MyCustomAdapter(this, item)
        listView.adapter = mAdpater
//        val adapter = listView.adapter

        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        val delbtn = findViewById<ImageButton>(R.id.list_del_btn)
        delbtn.setOnClickListener()
        {
//            fun onItemClick(av : AdapterView<?> , v : View , position : Int , id : Long)
//            {
//                var cb : CheckBox = (listView.getChildAt(position).findViewById(R.id.list_item))
//
//                if(cb.isChecked) {
//                    cb.setChecked(false)
//                }
//                else {
//                    cb.setChecked(true)
//                }
//            }
            val checkedItem = listView.checkedItemPositions

            (mAdpater.count downTo 0)
                .filter { checkedItem.get(it) }
                .forEach { item.removeAt(it) }

            listView.clearChoices()
            mAdpater.notifyDataSetChanged()
//            fun onClick(v : View)
//            {
//                val checkedItems : SparseBooleanArray = listView.checkedItemPositions
//                val count = adapter.count
//
//                for (i in 0 until count)
//                {
//                    if(checkedItems.get(i))
//                    {
//                        item.removeAt(i)
//                    }
//                }
//                listView.clearChoices()
//                adapter.notifyDataSetChanged()
//            }
        }

    }
}