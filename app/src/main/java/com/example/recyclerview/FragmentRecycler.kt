package com.example.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.Recycler.Todo
import com.example.recyclerview.Recycler.TodoAdapter
import com.example.recyclerview.databinding.FragmentRecyclerBinding

class FragmentRecycler: Fragment() {
    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todoList = mutableListOf(
            Todo("Trezit dimineata", false),
            Todo("Mancat", true)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this.context)


        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTotdo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size-1)
            binding.etTotdo.text.clear()
        }

    }
}