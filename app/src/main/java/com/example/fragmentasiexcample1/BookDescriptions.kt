package com.example.fragmentasiexcample1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_book_descriptions.*

class BookDescription : Fragment() {

    lateinit var arrbookdesc: Array<String>
    var bookindex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.activity_book_descriptions, container, false)

        arrbookdesc = resources.getStringArray(R.array.bookdescriptions)
        bookindex = if(savedInstanceState?.getInt("bookindex") == null) 0
        else { savedInstanceState.getInt("bookindex")}
        return v
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("bookindex", bookindex)
    }

    fun changeDescription(index: Int): Unit {
        bookindex = index
        txtdescription?.setText(arrbookdesc[bookindex])
        println("BOOK INDEX = $bookindex")
        txtdescription?.setText(arrbookdesc[bookindex])
        println(arrbookdesc[bookindex])
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeDescription(bookindex)
    }
}