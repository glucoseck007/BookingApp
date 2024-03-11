package fpt.edu.bookingapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import fpt.edu.bookingapp.DateConverter;
import fpt.edu.bookingapp.R;
import fpt.edu.bookingapp.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private ArrayList<Person> list;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public PersonAdapter(ArrayList<Person> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item, parent, false);
        return new PersonViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = list.get(position);
        if (person != null) {
            holder.tvId.setText(String.valueOf(person.getId())); // Convert to string explicitly
            holder.tvName.setText(person.getName()); // No conversion needed if person.getName() returns a string
            holder.tvDate.setText(DateConverter.toStringDate(person.getDate()));
            holder.tvValue.setText(String.valueOf(person.getValue())); // Convert to string explicitly
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvName, tvDate, tvValue;

        public PersonViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvValue = itemView.findViewById(R.id.tvValue);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
