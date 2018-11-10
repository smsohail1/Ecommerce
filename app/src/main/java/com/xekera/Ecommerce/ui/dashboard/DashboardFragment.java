package com.xekera.Ecommerce.ui.dashboard;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.*;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.xekera.Ecommerce.App;
import com.xekera.Ecommerce.R;
import com.xekera.Ecommerce.ui.BaseActivity;
import com.xekera.Ecommerce.ui.dashboard.dashboard_screen.CartFragment;
import com.xekera.Ecommerce.ui.dashboard.dashboard_screen.FragmentFavourites;
import com.xekera.Ecommerce.ui.dashboard.dashboard_screen.HistoryFragment;
import com.xekera.Ecommerce.ui.dashboard_shopping.ShopFragment;
import com.xekera.Ecommerce.util.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements DashboardMVP.View {

    @BindView(R.id.navigation)
    protected BottomNavigationView navigation;


    @Inject
    protected DashboardMVP.Presenter presenter;
    @Inject
    protected Utils utils;
    @Inject
    protected ToastUtil toastUtil;
    @Inject
    protected SessionManager sessionManager;


    private ProgressCustomDialogController progressDialogControllerPleaseWait;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        try {
            setTitle();
            showShoppingCartIcon();
            showLoginIcon();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);


        initializeViews(v);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //BottomNavigationView navigationView = (BottomNavigationView) getView().findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // ((BaseActivity) getActivity()).addDashboardFragment(new ShopFragment());
      Fragment fragment;
        fragment = new ShopFragment();
        addFragment(fragment);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    //  Toast.makeText(getActivity(), "Shop is selected", Toast.LENGTH_SHORT).show();
                      ((BaseActivity) getActivity()).popBackstack();
                    //((BaseActivity) getActivity()).addDashboardFragment(new ShopFragment());

                    fragment = new ShopFragment();
                    addFragment(fragment);
                    return true;
                case R.id.navigation_favourite:
                    //    Toast.makeText(getActivity(), "Wishlist is selected", Toast.LENGTH_SHORT).show();
                    //  ((BaseActivity) getActivity()).popBackstack();
                    //((BaseActivity) getActivity()).addDashboardFragment(new FragmentFavourites());
                    fragment = new FragmentFavourites();
                    addFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                    //  Toast.makeText(getActivity(), "Cart is selected", Toast.LENGTH_SHORT).show();
                    //((BaseActivity) getActivity()).popBackstack();
                   // ((BaseActivity) getActivity()).addDashboardFragment(new CartFragment());
                    fragment = new CartFragment();
                    addFragment(fragment);
                    return true;

                case R.id.navigation_History:
                    //  Toast.makeText(getActivity(), "History is selected", Toast.LENGTH_SHORT).show();
                    //((BaseActivity) getActivity()).popBackstack();
                    //((BaseActivity) getActivity()).addDashboardFragment(new HistoryFragment());
                    fragment = new HistoryFragment();
                    addFragment(fragment);
                    return true;
            }
            return false;
        }
    };


    private void addFragment(Fragment fragment) {
        // load fragment
        if (fragment != null) {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    private  void PopStack(Fragment fragment){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove(fragment);
        trans.commit();
        manager.popBackStack();

    }
    public void setTitle() {
        ((BaseActivity) getActivity()).setTitle(getString(R.string.Shop));
    }


    public void showShoppingCartIcon() {
        ((BaseActivity) getActivity()).showShoppingCartIcon();
    }


    public void showLoginIcon() {
        ((BaseActivity) getActivity()).showLoginIcon();
    }

    public void initializeViews(View v) {
        ButterKnife.bind(this, v);
        presenter.setView(this);

        progressDialogControllerPleaseWait = new ProgressCustomDialogController(getActivity(), R.string.please_wait);

       //  recyclerViewHome.setLayoutManager(new GridLayoutManager(getActivity(), 2));
       // recyclerViewHome.addItemDecoration(new GridSpacingItemDecoration(2, 20, true));

         presenter.setDashboardItems();

    }

//    @Override
//    public void setHomeRecyclerViewAdapter(DashboardAdapter homeAdapter) {
//         // recyclerViewHome.setAdapter(homeAdapter);
//    }


    @Override
    public void showProgressDialogPleaseWait() {
        progressDialogControllerPleaseWait.showDialog();
    }

    @Override
    public void hideProgressDialogPleaseWait() {
        progressDialogControllerPleaseWait.hideDialog();
    }

    @Override
    public void showToastShortTime(String message) {
        toastUtil.showToastShortTime(message);
    }

    @Override
    public void showToastLongTime(String message) {
        toastUtil.showToastLongTime(message);
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

}















