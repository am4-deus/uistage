package se.virtualstores.nextstepstageui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class ImageFragment extends Fragment {

    private ImageView imageView;
    private String url;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_image, container, false);
        imageView = root.findViewById(R.id.Image_View);
        Picasso.with(getActivity()).load(url).into(imageView, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                Picasso.with(getActivity()).load("file:///android_asset/no_image_available.jpg").into(imageView);
            }
        });
        return root;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
