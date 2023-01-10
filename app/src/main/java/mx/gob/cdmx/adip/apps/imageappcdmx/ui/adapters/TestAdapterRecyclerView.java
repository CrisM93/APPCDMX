package mx.gob.cdmx.adip.apps.imageappcdmx.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import mx.gob.cdmx.adip.apps.imageappcdmx.R;
import mx.gob.cdmx.adip.apps.imageappcdmx.model.Test;

public class TestAdapterRecyclerView extends RecyclerView.Adapter<TestAdapterRecyclerView.ViewHolder> {
    private List<Test> data;
    private Context context;
    private OnItemClickListener listener;

    public TestAdapterRecyclerView(Context context, List<Test> data, OnItemClickListener listener){
        this.data = data;
        this.context = context;
        this.listener = listener;
    }

    public void setData(List<Test> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Test test = data.get(position);
        Log.d("URL", data.get(position).getUrlImage());
        holder.tvTitle.setText(test.getTitulo());
        holder.tvSubtitle.setText(test.getDescription());
        Glide.with(context).load(data.get(position).getUrlImage()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView;
        ImageView img;
        TextView tvTitle, tvSubtitle;
        Button button_coment, button_like;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button_coment=itemView.findViewById(R.id.button_coment);
            button_like=itemView.findViewById(R.id.button_like);
            cardView = itemView.findViewById(R.id.cardView);
            img = itemView.findViewById(R.id.img);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
            cardView.setOnClickListener(this);
            button_coment.setOnClickListener(this);
            button_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Clic en button like", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onClick(View view) {

            if(view.getId() == R.id.button_coment){
                Test test = data.get(getAdapterPosition());
                //listener.onItemClick(view, test);
                listener.onItemComent(view, test);
            }else if(view.getId() == R.id.button_like){
                Test test = data.get(getAdapterPosition());
                listener.onItemLike(view, test);
            }else if(view.getId()==R.id.cardView){
                Toast.makeText(context, "Valores", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public interface OnItemClickListener {
        //void onItemClick(View view, Test test);
        void onItemComent(View view, Test test);
        void onItemLike(View view, Test test);
    }
}
