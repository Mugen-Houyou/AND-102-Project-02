package org.codepath.mygmail_lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // lateinit란 무엇인가?
    // 전역변수로 선언 후 null값을 지정하지 않고 초기화 하는 방법이 있습니다. 그것이 바로 lateinit 키워드를 사용한 초기화 방법입니다.
    // var 키워드를 사용하여 선언한 경우에만 lateinit를 사용할 수 있습니다.
    // val 키워드를 사용하여 선언한 경우에는 사용할 수 없어요. 그리고 primitive type에 적용할 수 없습니다.
    // 여기서 primitive type이란 Int, Boolean, Double 등의 코틀린에서 제공하는 기본적인 타입을 의미합니다.
    // 또한, getter & setter도 정의할 수 없습니다.
    lateinit var emails: List<Email>;
    // https://ddolcat.tistory.com/602

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val emailsRv = findViewById<RecyclerView>(R.id.emailsRv)
        // Fetch the list of emails
        emails = EmailFetcher.getEmails()
        // Create adapter passing in the list of emails
        val adapter = EmailAdapter(emails)
        // Attach the adapter to the RecyclerView to populate items
        emailsRv.adapter = adapter
        // Set layout manager to position the items
        emailsRv.layoutManager = LinearLayoutManager(this)
//
//        findViewById<Button>(R.id.submitButton).setOnClickListener {
//            // Fetch next 5 emails and display in RecyclerView
//            val newEmails = EmailFetcher.getNext5Emails();
//            // Add new emails to existing list of emails
//            (emails as MutableList<Email>).addAll(newEmails);
//            // Notify the adapter there's new emails so the RecyclerView layout is updated
//            adapter.notifyDataSetChanged();
//        }

        findViewById<Button>(R.id.submitButton).setOnClickListener {

            val itemName = findViewById<View>(R.id.editTextItemName) as EditText
            val itemNameString = itemName.text.toString()
            val numberPrice = findViewById<View>(R.id.editTextNumberPrice) as EditText
            val numberPriceString = numberPrice.text.toString()
            val detail = findViewById<View>(R.id.editTextDetail) as EditText
            val detailString = detail.text.toString()

            // Fetch next 5 emails and display in RecyclerView
            val newEmails = EmailFetcher.submitEmail(itemNameString,numberPriceString,detailString);
            // Add new emails to existing list of emails
            (emails as MutableList<Email>).addAll(newEmails);
            // Notify the adapter there's new emails so the RecyclerView layout is updated
            adapter.notifyDataSetChanged();
        }
    }
}