package com.dmss.dmssevent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dmss.dmssevent.R;
import com.dmss.dmssevent.common.ConstantKeys;
import com.dmss.dmssevent.common.DmsEventsAppController;
import com.dmss.dmssevent.common.DmsSharedPreferences;
import com.dmss.dmssevent.interfaces.BookingInterface;
import com.dmss.dmssevent.interfaces.SelectedPlayersInterface;
import com.dmss.dmssevent.models.SelectedPlayersResultModel;
import com.google.gson.JsonArray;

import java.util.ArrayList;

public class SecondPlayersListAdapter extends RecyclerView.Adapter<SecondPlayersListAdapter.MyViewHolder> {
    Context context;
    ArrayList<SelectedPlayersResultModel> selectedPlayersResultModelArrayList;

    BookingInterface bookingInterface;
    SelectedPlayersInterface selectedPlayersInterface;
    String text="";
    ArrayList<String> list;
    int callActivity;
    DmsEventsAppController appController;




    public SecondPlayersListAdapter(Context context, int callActivity, ArrayList<SelectedPlayersResultModel> selectedPlayersResultModelArrayList,
                                    BookingInterface bookingInterface,
                                    SelectedPlayersInterface selectedPlayersInterface, DmsEventsAppController appController) {
        this.context = context;
        this.selectedPlayersResultModelArrayList = selectedPlayersResultModelArrayList;
        this.bookingInterface = bookingInterface;
        this.callActivity = callActivity;
        this.selectedPlayersInterface = selectedPlayersInterface;
        this.appController = appController;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_player_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final SelectedPlayersResultModel selectedPlayersResultModels = selectedPlayersResultModelArrayList.get(position);


        holder.userNameTextView.setText(selectedPlayersResultModelArrayList.get(position).getDisplayName());
        holder.deptNameTextView.setText(selectedPlayersResultModelArrayList.get(position).getDeptName());
        String url= ConstantKeys.getImageUrl +selectedPlayersResultModelArrayList.get(position).getProfilePhoto();
        Glide.with(context).load(url).apply(RequestOptions.circleCropTransform()).into(holder.userImageView);

        holder.selectImageView.setImageResource(selectedPlayersResultModelArrayList.get(position).isSelected() ? R.drawable.icon_filter_selected : R.drawable.icon_filter_unselected);


        holder.selectImageViewLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=selectedPlayersResultModelArrayList.get(position).getId();
                int idUser= DmsSharedPreferences.getUserDetails(context).getId();

                if(selectedId== idUser){
                    Toast.makeText(context,"You Can't Select Your Name",Toast.LENGTH_SHORT).show();
                }else {
                    //Toast.makeText(context,"You Can't Select/Unselect this player",Toast.LENGTH_SHORT).show();
                    selectedPlayersInterface.onClick(position,null,null);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return selectedPlayersResultModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userNameTextView, deptNameTextView;
        ImageView userImageView,selectImageView;
        LinearLayout selectImageViewLy;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            userNameTextView = (TextView) itemView.findViewById(R.id.userNameTextView);
            deptNameTextView = (TextView) itemView.findViewById(R.id.deptNameTextView);
            userImageView = (ImageView) itemView.findViewById(R.id.userImageView);
            selectImageView = (ImageView) itemView.findViewById(R.id.selectImageView);
            selectImageViewLy = (LinearLayout) itemView.findViewById(R.id.selectImageViewLy);

        }
    }
}
