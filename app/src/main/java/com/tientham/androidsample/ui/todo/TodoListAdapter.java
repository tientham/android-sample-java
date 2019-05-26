package com.tientham.androidsample.ui.todo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tientham.androidsample.R;
import com.tientham.androidsample.model.TodoModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-27.
 */
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    public interface OnItemClickListener {
        void onUserItemClicked(TodoModel userModel);
    }

    private List<TodoModel> todosCollection;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    @Inject
    TodoListAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.todosCollection = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.todosCollection != null) ? this.todosCollection.size() : 0;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, final int position) {
        final TodoModel todoModel = this.todosCollection.get(position);
        holder.tv_title.setText(todoModel.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (TodoListAdapter.this.onItemClickListener != null) {
                    TodoListAdapter.this.onItemClickListener.onUserItemClicked(todoModel);
                }
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setTodosCollection(Collection<TodoModel> todosCollection) {
        this.validateTodosCollection(todosCollection);
        this.todosCollection = (List<TodoModel>) todosCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateTodosCollection(Collection<TodoModel> todosCollection) {
        if (todosCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title)
        TextView tv_title;

        TodoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
