package in.mangaldeep;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    //6.2
    private ArrayList<carditem> mcardlist;

    //    First we have to create a class step1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

//        we have to declare the textview and imageview  here step4
        public ImageView imageView;
        public TextView textView;



        //        We have to generate a constructor step2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

//            continuing that step4
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }
    }

    // To know how much items to generate and whats property to use Step 6.1
    public ExampleAdapter(ArrayList<carditem> carditems){
        mcardlist = carditems;
    }


//    3 methods starts here step3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //       inflate here the customization that we did step 5
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycard, parent , false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
     // step 7

        //Here the total number of cards are found.
        carditem currentItem = mcardlist.get(position);

        //Now we have to call the imageResource and textResource from getters in cardItem.java !
        holder.imageView.setImageResource(currentItem.getmImageResource());
        holder.textView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
        //The total number of methods we are using!
        return mcardlist.size();
    }
    
//    3 methods ends here

}
