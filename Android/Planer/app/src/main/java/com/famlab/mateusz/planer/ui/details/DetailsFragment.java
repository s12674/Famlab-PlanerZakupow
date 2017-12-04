package com.famlab.mateusz.planer.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.famlab.mateusz.planer.R;
import com.famlab.mateusz.planer.databinding.FragmentDetailsBinding;
import com.famlab.mateusz.planer.ds.ApiDataSource;
import com.famlab.mateusz.planer.ds.models.Product;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class DetailsFragment extends Fragment implements DetailsContract.View {

    FragmentDetailsBinding binding;
    private DetailsContract.Presenter presenter;
    private Product product;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_details, container, false);
        binding = FragmentDetailsBinding.inflate(LayoutInflater.from(getContext()), (LinearLayout) root.findViewById(R.id.frame), false);
        Intent intent = this.getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        presenter = new DetailsPresenter(this, new ApiDataSource());
        product = (Product) bundle.getSerializable("product");
        presenter.getProduct(product);
        System.out.println(product.name + " PRODUCT");
        return binding.getRoot();
    }

    @Override
    public void showProduct(Product product){
        binding.setProduct(product);
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.getProduct(product);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        presenter.getProduct(product);
    }


}