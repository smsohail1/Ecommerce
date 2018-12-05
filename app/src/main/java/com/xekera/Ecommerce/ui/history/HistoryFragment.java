package com.xekera.Ecommerce.ui.history;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xekera.Ecommerce.App;
import com.xekera.Ecommerce.R;
import com.xekera.Ecommerce.data.room.model.Booking;
import com.xekera.Ecommerce.ui.BaseActivity;
import com.xekera.Ecommerce.ui.adapter.HistoryAdapter;
import com.xekera.Ecommerce.util.SessionManager;
import com.xekera.Ecommerce.util.SnackUtil;
import com.xekera.Ecommerce.util.ToastUtil;
import com.xekera.Ecommerce.util.Utils;

import javax.inject.Inject;
import java.util.List;

public class HistoryFragment extends Fragment implements HistoryMVP.View, HistoryAdapter.IHistoryCancelOrderAdapter {


    @BindView(R.id.recyclerViewAddToCartDetails)
    protected RecyclerView recyclerViewAddToCartDetails;
    @BindView(R.id.linearParent)
    protected LinearLayout linearParent;
    // @BindView(R.id.subTotalValueTextView)
    //protected TextView subTotalValueTextView;
    //  @BindView(R.id.shippingValueTextView)
    //protected TextView shippingValueTextView;
    @BindView(R.id.totalValueTextView)
    protected TextView totalValueTextView;
    @BindView(R.id.txtNoCartItemFound)
    protected TextView txtNoCartItemFound;

    @Inject
    protected HistoryMVP.Presenter presenter;
    @Inject
    protected Utils utils;
    @Inject
    protected ToastUtil toastUtil;
    @Inject
    protected SnackUtil snackUtil;
    @Inject
    protected SessionManager sessionManager;

    HistoryAdapter adapter;


    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            ((BaseActivity) getActivity()).showBottomNavigation();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_history, container, false);

        initializeViews(v);

        return v;
    }

    public void setTitle() {
        // ((BaseActivity) getActivity()).setTitle(getString(R.string.history_dashboard));
    }


    private void initializeViews(View v) {
        ButterKnife.bind(this, v);
        presenter.setView(this);
        ((BaseActivity) getActivity()).showBottomNavigation();

        recyclerViewAddToCartDetails.setLayoutManager(new LinearLayoutManager(getActivity()));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.fetchOrderDetails();

            }
        }, 600);
    }


    @Override
    public void showToastShortTime(String message) {
        toastUtil.showToastShortTime(message);
    }

    @Override
    public void showToastLongTime(String message) {
        toastUtil.showToastLongTime(message);
    }


    public void showSnackBarShortTime(String message) {
        snackUtil.showSnackBarShortTime(getView(), message);
    }

    @Override
    public void showRecylerViewProductsDetail(HistoryAdapter historyAdapter) {
        recyclerViewAddToCartDetails.setAdapter(historyAdapter);

    }

    @Override
    public void showRecyclerView() {
        linearParent.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRecyclerView() {
        linearParent.setVisibility(View.GONE);
    }

    @Override
    public void setCartCounts(long counts) {

        ((BaseActivity) getActivity()).setCartsCounts(counts, 3, "History");

    }

    @Override
    public void setCartCounterTextview(int counts) {
        ((BaseActivity) getActivity()).showTotalCartsCount(counts);

    }

    @Override
    public void setParentFields() {
        //  subTotalValueTextView.setText("0");
        //   shippingValueTextView.setText("0");
        totalValueTextView.setText("0");
    }

    @Override
    public void txtNoCartItemFound() {
        txtNoCartItemFound.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideNoCartItemFound() {
        txtNoCartItemFound.setVisibility(View.GONE);
    }

    @Override
    public void setSubTotal(String setSubToal) {
        if (!utils.isTextNullOrEmpty(setSubToal)) {
//            subTotalValueTextView.setText(setSubToal);
            //  String flatShippingRateStr = shippingValueTextView.getText().toString();
            // long flatShippingRateLong = 0;
            //   flatShippingRateLong = Long.valueOf(setSubToal) + Long.valueOf(flatShippingRateStr);
            totalValueTextView.setText(String.valueOf(setSubToal));

        } else {
            totalValueTextView.setText("0");

            //          subTotalValueTextView.setText("0");
        }


    }


    @Override
    public void setAdapter(List<Booking> addToCarts) {
        //   if (adapter == null) {
        adapter = new HistoryAdapter(getActivity(), addToCarts, this);
        showRecylerViewProductsDetail(adapter);
        // } else {
        //    adapter.removeAll();
        //   adapter.addAll(addToCarts);
        // }
        getSubTotal(addToCarts);

    }


    private void getSubTotal(List<Booking> addToCarts) {
        long price = 0;

        for (Booking i : addToCarts) {
            price = price + Long.valueOf(i.getItemPrice()) + Long.valueOf(i.getFlatCharges());
        }
        setSubTotal(String.valueOf(price));
        setCartCounts(addToCarts.size());

    }


    @Override
    public void showSnackBarLongTime(String message, View view) {
        snackUtil.showSnackBarLongTime(view, message);
    }

    @Override
    public void showSnackBarShortTime(String message, View view) {
        snackUtil.showSnackBarShortTime(view, message);
    }

    boolean isShowing = true;

    @Override
    public void cancelOrder(String orderID) {
        if (isShowing) {
            isShowing = false;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //isShowing = true;
                    // if (isShowing)
                    showCancelDialog(getActivity(), "Alert", "Do you want to cancel this order?");
                    isShowing = true;
                }
            }, 200);
        }
    }

    private void showCancelDialog(Context context, String title, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_cancel_dialog);

        Button cancel = dialog.findViewById(R.id.cancel);
        Button submit = dialog.findViewById(R.id.submit);
        TextView txtMessage = dialog.findViewById(R.id.txtMessage);
        TextView txtTitle = dialog.findViewById(R.id.txtTitle);

        txtMessage.setText("" + message);
        txtTitle.setText("" + title);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sessionManager.logoutUser();
                //  startActivity(new Intent(BaseActivity.this, LoginActivity.class));
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        if (!dialog.isShowing()) {
            dialog.show();
        }

    }

}